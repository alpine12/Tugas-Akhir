package id.BentengBuahNaga.App.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.pixplicity.easyprefs.library.Prefs;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import cn.pedant.SweetAlert.SweetAlertDialog;
import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.DetailMenuTampilanContract;
import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;
import id.BentengBuahNaga.App.activity.presenter.DetailMenuTampilanPresenter;
import id.BentengBuahNaga.App.helper.FormatRp;
import id.BentengBuahNaga.App.helper.SharedPreff;
import id.BentengBuahNaga.App.network.InitRetrofit;
import mehdi.sakout.fancybuttons.FancyButton;

public class DetailMenuTampilan extends AppCompatActivity implements DetailMenuTampilanContract.View {
    private static final String TAG = "DetailMenuTampilan";
    private DetailMenuTampilanPresenter presenter;
    private Context context;
    private ShimmerFrameLayout shimmerFrameLayout;
    private ImageView imgHolder;
    private TextView tvTitle;
    private TextView tvJenisMenu;
    private TextView tvStockmenu;
    private TextView tvHarga;
    private TextView tvDescripsi;
    private ConstraintLayout containerItem;
    private ImageView back;
    private FancyButton btnPesan;
    private DaftarMenuModel data;
    private String id = "";
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu_tampilan);

        initUi();
        initEvent();
    }

    private void initUi() {

        id = getIntent().getStringExtra("param");

        context = this;
        presenter = new DetailMenuTampilanPresenter(this);
        back = findViewById(R.id.backArrow);
//        shimmerFrameLayout = findViewById(R.id.ShimmerFrameLayout);
//        containerItem = findViewById(R.id.containerItem);
        imgHolder = findViewById(R.id.img_iconMenu);
        tvJenisMenu  =findViewById(R.id.tv_jenisMenu);
        tvStockmenu = findViewById(R.id.tv_stokMenu);
        tvTitle = findViewById(R.id.tv_titleMenu);
        tvHarga = findViewById(R.id.tv_hargaMenu);
        tvDescripsi = findViewById(R.id.tv_DeskripsiMenu);
         btnPesan = findViewById(R.id.btn_pesan_snack);

    }

    private void initEvent() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setCollapsedTitleTextColor(
                ContextCompat.getColor(this, R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this, R.color.white));
    }


    @Override
    public void loadingItem() {
//        shimmerFrameLayout.stopShimmer();
        //      shimmerFrameLayout.setVisibility(View.GONE);
        //    containerItem.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadItem(DaftarMenuModel menu) {
        data = menu;
        collapsingToolbarLayout.setTitle(menu.getNamaMenu());
        if (menu.getKategori().equals("1")){
            tvJenisMenu.setText("Makanan Berat");
        }else if (menu.getKategori().equals("2")){
            tvJenisMenu.setText("Minuman");
        }else {
            tvJenisMenu.setText("Makanan Ringan");
        }
        tvStockmenu.setText("Sisa  "+menu.getStok()+" |");
        Picasso.get().load(InitRetrofit.getIMAGEURL() + menu.getGambar()).fit()
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(imgHolder);
        tvTitle.setText(menu.getNamaMenu());
        tvHarga.setText("Harga "+FormatRp.FormatRp(menu.getHarga()));
        tvDescripsi.setText(menu.getDeskripsi());


        int stok = Integer.valueOf(data.getStok());

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stok < 1) {
                    Toast.makeText(context, "Stok Habis", Toast.LENGTH_SHORT).show();
                } else {
                    btnPesan();
                }
            }
        });
    }

    private void btnPesan() {
        String idPelanggan, idMenu, harga;
        final String[] jumlah = new String[1];
        idPelanggan = Prefs.getString(SharedPreff.getIdPelanggan(), null);
        idMenu = data.getIdMenu();
        harga = data.getHarga();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );

        params.setMargins(100, 0, 0, 0);
        ElegantNumberButton button = new ElegantNumberButton(context);
        button.setLayoutParams(params);
        button.setNumber("1");
        button.setRange(1, 10);
        button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = button.getNumber();
                jumlah[0] = num;
            }
        });
        new SweetAlertDialog(context, SweetAlertDialog.NORMAL_TYPE)
                .setTitleText("Masukan Jumlah Pesanan")
                .setConfirmText("Pesan")
                .setCustomView(button)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        if (jumlah[0] == null) {
                            jumlah[0] = "1";
                        }

                        HashMap<String, String> data = new HashMap();
                        data.put("a", idPelanggan);
                        data.put("b", idMenu);
                        data.put("c", jumlah[0]);
                        data.put("d", harga);
                        presenter.tambahKeranang(data);
                        sweetAlertDialog.dismissWithAnimation();
                    }
                })
                .show();
    }

    @Override
    public void tampilDialogPesan(String titel, String pesan) {
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(titel)
                .setContentText(pesan)
                .show();
    }

    @Override
    public void tampilNotif(String Message) {
        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.bindItem(id);
//        shimmerFrameLayout.startShimmer();
        //  containerItem.setVisibility(View.GONE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // shimmerFrameLayout.stopShimmer();
    }
}
