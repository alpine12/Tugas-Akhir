package id.BentengBuahNaga.App.activity.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.HashMap;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.adapter.KeranjangAdapter;
import id.BentengBuahNaga.App.activity.contract.KeranjangFragmentContract;
import id.BentengBuahNaga.App.activity.model.KeranjangFragmentModel;
import id.BentengBuahNaga.App.activity.model.PromoModel;
import id.BentengBuahNaga.App.activity.presenter.KeranjangFragmentPresenter;
import id.BentengBuahNaga.App.helper.FormatRp;
import id.BentengBuahNaga.App.helper.SharedPreff;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class KeranjangFragment extends Fragment implements KeranjangFragmentContract.View {
    private static final String TAG = "KeranjangFragment";
    private RecyclerView rvKeranjang;
    private RecyclerView.LayoutManager layoutManager;
    KeranjangFragmentPresenter presenter;
    private KeranjangAdapter adapter;
    private String id;
    private TextView tvTotal;
    private FancyButton btnBayar;
    private TextView potongan_diskon;
    private String totalPembayran;
    private String listKeranjang;
    private List<KeranjangFragmentModel> items;
    private CardView container;
    private ProgressDialog dialog;
    private EditText inputPromo;
    private FancyButton submitPromo;
    private Context context;
    private View empetyView;
   private int potongan;

    public KeranjangFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_keranjang, container, false);

        initUi(view);
        initEvent();

        return view;
    }

    private void initUi(View view) {
        context = getActivity();
        presenter = new KeranjangFragmentPresenter(this);
        rvKeranjang = view.findViewById(R.id.recyclerview);
        potongan_diskon = view.findViewById(R.id.tv_diskon);
        tvTotal = view.findViewById(R.id.tv_total);
        btnBayar = view.findViewById(R.id.btn_pesan_snack);
        container = view.findViewById(R.id.container);
        inputPromo = view.findViewById(R.id.et_inputPromo);
        submitPromo = view.findViewById(R.id.btn_submitPromo);
        empetyView = getLayoutInflater().inflate(R.layout.empety_view, (ViewGroup) rvKeranjang.getParent(), false);
    }

    private void initEvent() {
        id = Prefs.getString(SharedPreff.getIdPelanggan(), null);
        layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rvKeranjang.setLayoutManager(layoutManager);
        rvKeranjang.setHasFixedSize(true);
        adapter = new KeranjangAdapter(R.layout.list_item_daftar_keranjang);
        rvKeranjang.setAdapter(adapter);
        adapter.setEmptyView(empetyView);
        presenter.onCLick();

        submitPromo.setVisibility(View.GONE);
        inputPromo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(inputPromo.getText().toString())) {
                    submitPromo.setVisibility(View.GONE);
                } else {
                    submitPromo.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void loadPesanan(List<KeranjangFragmentModel> item) {

        items = item;
        Log.d(TAG, "loadPesanan: " + items.size());
        if (items.size() > 0) {
            presenter.handeShowKeranjang();
            presenter.totalPesanan(item, 0);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            listKeranjang = gson.toJson(items);
            adapter.setNewData(item);
            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                }
            });
            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    KeranjangFragmentModel item = (KeranjangFragmentModel) adapter.getItem(position);
                    switch (view.getId()) {
                        case R.id.btn_delete:
                            new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("Hapus Pesanan Menu")
                                    .setContentText("Apakah Anda Yakin Untuk Membatalkan ?")
                                    .setConfirmText("Hapus menu")
                                    .setCancelText("Tidak")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            presenter.hapusMenuPesanan(item.getIdMenu(), position);

                                            listKeranjang = gson.toJson(items);
                                            Log.d(TAG, "onClick: " + listKeranjang);
                                            sweetAlertDialog.dismissWithAnimation();
                                            if (items.size() == 1) {
                                                container.setVisibility(View.GONE);
                                            }
                                        }
                                    })
                                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            sweetAlertDialog.dismissWithAnimation();
                                        }
                                    })
                                    .show();
                            break;

                        case R.id.btn_edit:
                            final String[] num = new String[1];
                            ElegantNumberButton button = new ElegantNumberButton(context);
                            button.setNumber(item.getJumlah());
                            button.setRange(1, 10);
                            button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                     num[0] = button.getNumber();
                                }
                            });
                            new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("Ubah Pesanan")
                                    .setConfirmText("Selesai")
                                    .setCustomView(button)
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            String jumlah;
                                            if (num[0]==null){
                                                jumlah = item.getJumlah();
                                            }else {
                                                jumlah = num[0];
                                            }
                                            item.setJumlah(jumlah);
                                            adapter.notifyItemChanged(position);
                                            listKeranjang = gson.toJson(items);
                                            presenter.totalPesanan(items,potongan);
                                            Log.d(TAG, "onClick: " + listKeranjang);
                                            sweetAlertDialog.dismissWithAnimation();
                                        }
                                    })
                                    .show();
                            break;
                    }
                }
            });
        } else {
            presenter.handleHideKeranjang();
        }
    }

    @Override
    public void hapusPosisiMenu(int position) {
        adapter.remove(position);
        presenter.totalPesanan(items, potongan);
    }

    void cek() {
        Log.d(TAG, "cek: " + listKeranjang);
    }

    @Override
    public void kodePromo(PromoModel item) {
        if (item != null) {
            potongan = Integer.valueOf(item.getPotongan());
            presenter.totalPesanan(items, potongan);
        } else {
            presenter.totalPesanan(items, 0);
        }
    }

    @Override
    public void viewKeranjang() {
        // rvKeranjang.setVisibility(View.VISIBLE);
        container.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideKeranjang() {
        // rvKeranjang.setVisibility(View.GONE);
        adapter.setNewData(null);
        container.setVisibility(View.GONE);
    }

    @Override
    public void totalPesanan(String total, int diskon) {
        totalPembayran = total;
        String bayar = null;
        if (diskon != 0) {
            int totals = Integer.valueOf(total);
            int potongan = ((totals * diskon) / 100);
            bayar = String.valueOf(totals - potongan);
            potongan_diskon.setText("Besar Potongan " + diskon + "%" + " " + FormatRp.FormatRp(String.valueOf(potongan)));
        } else {
            bayar = total;
            potongan_diskon.setText(FormatRp.FormatRp("0"));
        }
        tvTotal.setText(FormatRp.FormatRp(bayar));
    }

    @Override
    public void tampilLoading() {
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("LOADING...");
        dialog.setCancelable(false);
        dialog.show();

    }

    @Override
    public void tutupLoading() {
        dialog.dismiss();
    }

    @Override
    public void tampilPesan(String pesan) {
        Toast.makeText(getActivity(), pesan, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void buttonOnclick() {
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idPelanggan, kodeMeja, idPengguna, kodePromo, totalPembayaran;

                idPelanggan = Prefs.getString(SharedPreff.getIdPelanggan(), null);
                kodeMeja = Prefs.getString(SharedPreff.getMeja(), null);
                idPengguna = "";
                if (TextUtils.isEmpty(inputPromo.getText().toString())){
                    kodePromo = "null";
                }else {
                    kodePromo = inputPromo.getText().toString();
                }
                totalPembayaran = totalPembayran;

                final EditText catatan = new EditText(context);
                catatan.setLines(8);
                catatan.setMaxLines(8);
                catatan.setHint("Masukan catatan untuk pesanan anda");
                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Apakah anda ingin melakukan pembayaran ?")
                        .setConfirmText("Ok")
                        .setCustomView(catatan)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();

                                HashMap<String, String> data = new HashMap<>();
                                data.put("a", idPelanggan);
                                data.put("b", kodeMeja);
                                data.put("c", idPengguna);
                                data.put("d", kodePromo);
                                data.put("e", catatan.getText().toString());
                                data.put("f", totalPembayaran);
                                data.put("LIST_CART", listKeranjang);

                                presenter.bayarPesnan(data, idPelanggan, items);
                            }
                        })
                        .show();
            }
        });

        submitPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kode = inputPromo.getText().toString();
                presenter.kodePromo(kode);
            }
        });
    }

    @Override
    public void tampilDialogSukses(String title, String pesan) {
        new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(title)
                .setContentText(pesan)
                .show();
    }

    @Override
    public void tampilDialogGagal(String title, String pesan) {
        new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(pesan)
                .show();
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.daftarKeranjang(id);
        Log.d(TAG, "onResume: " + id);
    }
}
