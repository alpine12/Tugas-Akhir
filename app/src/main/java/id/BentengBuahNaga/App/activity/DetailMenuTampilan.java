package id.BentengBuahNaga.App.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.DetailMenuTampilanContract;
import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;
import id.BentengBuahNaga.App.activity.presenter.DetailMenuTampilanPresenter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu_tampilan);

        initUi();
        initEvent();
    }

    private void initUi() {
        context = this;
        presenter = new DetailMenuTampilanPresenter(this);
        shimmerFrameLayout = findViewById(R.id.ShimmerFrameLayout);
        containerItem = findViewById(R.id.containerItem);
        imgHolder = findViewById(R.id.img_iconMenu);
        tvTitle = findViewById(R.id.tv_titleMenu);
        tvHarga = findViewById(R.id.tv_hargaMenu);
        tvDescripsi = findViewById(R.id.tv_DeskripsiMenu);
    }

    private void initEvent() {
        String id = getIntent().getStringExtra("param");
        presenter.bindItem(id);
    }

    @Override
    public void loadingItem() {
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
        containerItem.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadItem(DaftarMenuModel menu) {
        Picasso.get().load(InitRetrofit.getIMAGEURL()+menu.getGambar()).fit().into(imgHolder);
        tvTitle.setText(menu.getNamaMenu());
        tvHarga.setText(menu.getHarga());
        tvDescripsi.setText(menu.getDeskripsi());
    }

    @Override
    protected void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();
        containerItem.setVisibility(View.GONE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmer();
    }
}
