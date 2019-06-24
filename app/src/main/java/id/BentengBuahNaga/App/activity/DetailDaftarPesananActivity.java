package id.BentengBuahNaga.App.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_daftar_pesanan);

        presenter.initMain();

    }

    @Override
    public void initView() {
        context = this;
        rvDetailPesanan = findViewById(R.id.rv_Detaildaftarpesanan);

    }

    @Override
    public void initEvent() {
        rvDetailPesanan.setHasFixedSize(true);
        rvDetailPesanan.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        String idPesanan = getIntent().getStringExtra("param");
        presenter.daftarPesanan(idPesanan);

    }

    @Override
    public void loadData(List<DetailDaftarPesananModel> item) {
        adapter = new DaftarDetailPesananAdapter(context, item);
        rvDetailPesanan.setAdapter(adapter);
    }

    @Override
    public void tampilLoading() {

    }

    @Override
    public void tampilPesan(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
