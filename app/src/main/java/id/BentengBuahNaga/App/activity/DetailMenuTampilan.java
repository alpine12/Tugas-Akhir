package id.BentengBuahNaga.App.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.pixplicity.easyprefs.library.Prefs;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.DetailMenuTampilanContract;
import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;
import id.BentengBuahNaga.App.activity.presenter.DetailMenuTampilanPresenter;
import id.BentengBuahNaga.App.helper.SharedPreff;
import id.BentengBuahNaga.App.network.InitRetrofit;

public class DetailMenuTampilan extends AppCompatActivity implements DetailMenuTampilanContract.View {
    private static final String TAG = "DetailMenuTampilan";
    private DetailMenuTampilanPresenter presenter;
    private Context context;
    private ShimmerFrameLayout shimmerFrameLayout;
    private ImageView imgHolder;
    private TextView tvTitle;
    private TextView tvHarga;
    private TextView tvDescripsi;
    private ConstraintLayout containerItem;
    private ImageView back;
    private TextView btnPesan;
    private DaftarMenuModel data;
    private String id = "";

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
        shimmerFrameLayout = findViewById(R.id.ShimmerFrameLayout);
        containerItem = findViewById(R.id.containerItem);
        imgHolder = findViewById(R.id.img_iconMenu);
        tvTitle = findViewById(R.id.tv_titleMenu);
        tvHarga = findViewById(R.id.tv_hargaMenu);
        tvDescripsi = findViewById(R.id.tv_DeskripsiMenu);
        btnPesan = findViewById(R.id.btn_pesan);

    }

    private void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idPelanggan, idMenu, jumlah, harga;
                idPelanggan = Prefs.getString(SharedPreff.getIdPelanggan(), null);
                idMenu = data.getIdMenu();
                jumlah = "1";
                harga = data.getHarga();

                HashMap<String, String> data = new HashMap();
                data.put("a", idPelanggan);
                data.put("b", idMenu);
                data.put("c", jumlah);
                data.put("d", harga);

                presenter.tambahKeranang(data);
            }
        });
    }

    @Override
    public void loadingItem() {
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
        containerItem.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadItem(DaftarMenuModel menu) {
        data = menu;
        Picasso.get().load(InitRetrofit.getIMAGEURL() + menu.getGambar()).fit()
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(imgHolder);
        tvTitle.setText(menu.getNamaMenu());
        tvHarga.setText(menu.getHarga());
        tvDescripsi.setText(menu.getDeskripsi());
    }

    @Override
    public void tampilDialogPesan() {

    }

    @Override
    public void tampilNotif(String Message) {
        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.bindItem(id);
        shimmerFrameLayout.startShimmer();
        containerItem.setVisibility(View.GONE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmer();
    }
}
