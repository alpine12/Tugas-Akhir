package id.BentengBuahNaga.App.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.adapter.DaftarDetailPesananAdapter;
import id.BentengBuahNaga.App.activity.contract.DetailDaftarPesananContract;
import id.BentengBuahNaga.App.activity.model.DetailDaftarPesananModel;
import id.BentengBuahNaga.App.activity.presenter.DetailDaftarPesananPresenter;

public class DetailDaftarPesananActivity extends AppCompatActivity implements DetailDaftarPesananContract.View {
    private static final String TAG = "DetailDaftarPesananActi";
    private Context context;
    private DetailDaftarPesananPresenter presenter;
    private RecyclerView rvDetailPesanan;
    private DaftarDetailPesananAdapter adapter;
    private ImageButton back;
    private TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_daftar_pesanan);

        presenter = new DetailDaftarPesananPresenter(this);
        presenter.initMain();

    }

    @Override
    public void initView() {
        context = this;
        back = findViewById(R.id.backArrow);
        title = findViewById(R.id.title_toolbar);
        rvDetailPesanan = findViewById(R.id.rv_Detaildaftarpesanan);

    }

    @Override
    public void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title.setText("Daftar Pesanan");
        rvDetailPesanan.setHasFixedSize(true);
        rvDetailPesanan.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

    }

    @Override
    public void loadData(List<DetailDaftarPesananModel> item) {
        adapter = new DaftarDetailPesananAdapter(context, item);
        rvDetailPesanan.setAdapter(adapter);
        Log.d(TAG, "loadData: "+item.toString());
    }

    @Override
    public void tampilLoading() {

    }

    @Override
    public void tampilPesan(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String idPesanan = getIntent().getStringExtra("param");
        presenter.daftarPesanan(idPesanan);
    }
}
