package id.BentengBuahNaga.App.activity.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.HashMap;
import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.adapter.KeranjangAdapter;
import id.BentengBuahNaga.App.activity.contract.KeranjangFragmentContract;
import id.BentengBuahNaga.App.activity.model.KeranjangFragmentModel;
import id.BentengBuahNaga.App.activity.presenter.KeranjangFragmentPresenter;
import id.BentengBuahNaga.App.helper.FormatRp;
import id.BentengBuahNaga.App.helper.SharedPreff;

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
    private TextView btnBayar;
    private String totalPembayran;
    private String listKeranjang;
    private List<KeranjangFragmentModel> items;
    private CardView container;
    private ProgressDialog dialog;
    private EditText inputPromo;


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
        presenter = new KeranjangFragmentPresenter(this);
        rvKeranjang = view.findViewById(R.id.rvKeranjang);
        tvTotal = view.findViewById(R.id.tv_total);
        btnBayar = view.findViewById(R.id.btn_bayar);
        container = view.findViewById(R.id.container);
        inputPromo = view.findViewById(R.id.et_inputPromo);
    }

    private void initEvent() {
        id = Prefs.getString(SharedPreff.getIdPelanggan(), null);
        layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rvKeranjang.setLayoutManager(layoutManager);
        rvKeranjang.setHasFixedSize(true);
        presenter.onCLick();
    }

    @Override
    public void loadPesanan(List<KeranjangFragmentModel> item) {

        items = item;
        if (items.size()>0){
            adapter = new KeranjangAdapter(items, getActivity());
            rvKeranjang.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            presenter.totalPesanan(item);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            listKeranjang = gson.toJson(item);
        }
    }

    @Override
    public void viewKeranjang() {
        rvKeranjang.setVisibility(View.VISIBLE);
        container.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideKeranjang() {
        rvKeranjang.setVisibility(View.GONE);
        container.setVisibility(View.GONE);
    }

    @Override
    public void totalPesanan(String total) {
        totalPembayran = total;
        tvTotal.setText(FormatRp.FormatRp(total));
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

                String idPelanggan, kodeMeja, idPengguna, kodePromo, catatan, totalPembayaran;

                idPelanggan = Prefs.getString(SharedPreff.getIdPelanggan(), null);
                kodeMeja = Prefs.getString(SharedPreff.getMeja(), null);
                idPengguna = "";
                kodePromo = inputPromo.getText().toString();
                catatan = "wkwkwk";
                totalPembayaran = totalPembayran;

                HashMap<String, String> data = new HashMap<>();
                data.put("a", idPelanggan);
                data.put("b", kodeMeja);
                data.put("c", idPengguna);
                data.put("d", kodePromo);
                data.put("e", catatan);
                data.put("f", totalPembayaran);
                data.put("LIST_CART", listKeranjang);
                presenter.bayarPesnan(data, idPelanggan, items);
                Log.d(TAG, "onClick: " + listKeranjang);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.daftarKeranjang(id);
        Log.d(TAG, "onResume: " + id);
    }
}
