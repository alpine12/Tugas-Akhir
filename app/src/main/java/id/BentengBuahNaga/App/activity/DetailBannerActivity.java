package id.BentengBuahNaga.App.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.DetailBannerContract;
import id.BentengBuahNaga.App.activity.model.BerandaFragmentModel;
import id.BentengBuahNaga.App.activity.presenter.DetailBannerPresenter;
import id.BentengBuahNaga.App.network.InitRetrofit;

public class DetailBannerActivity extends AppCompatActivity implements DetailBannerContract.View {
    private static final String TAG = "DetailBannerActivity";
    private DetailBannerPresenter presenter;
    private ImageView icon;
    private TextView tv_deskripsi;
    private ImageButton back;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_banner);
        presenter= new DetailBannerPresenter(this);
        presenter.initMain();
    }

    @Override
    public void initView() {
        back = findViewById(R.id.backArrow);
        title = findViewById(R.id.title_toolbar);
        icon = findViewById(R.id.img_iconBanner);
        tv_deskripsi = findViewById(R.id.descripsi_banner);
    }

    @Override
    public void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title.setText("Event");

        Gson gson = new Gson();
        String data = getIntent().getStringExtra("param");
        BerandaFragmentModel item = gson.fromJson(data, BerandaFragmentModel.class);
        Picasso.get().load(InitRetrofit.getImageurlBanner()+item.getGambar()).fit()
                .into(icon);
        tv_deskripsi.setText(item.getDeskripsi());

    }
}
