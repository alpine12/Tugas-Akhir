package id.BentengBuahNaga.App.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.adapter.DaftarPesananAdapter;
import id.BentengBuahNaga.App.activity.contract.DaftarPesananContract;
import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;
import id.BentengBuahNaga.App.activity.presenter.DaftarPesananPresenter;
import id.BentengBuahNaga.App.utils.PindahActivity;

public class DaftarPesananActivity extends AppCompatActivity implements DaftarPesananContract.View {
    private static final String TAG = "DaftarPesananActivity";
    private RecyclerView rvDaftarPesanan;
    private DaftarPesananPresenter presenter;
    private RecyclerView.LayoutManager layoutManager;
    private DaftarPesananAdapter adapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pesanan);

        presenter = new DaftarPesananPresenter(this);
        presenter.initMain();
    }

    @Override
    public void initView() {
        mContext = this;
        rvDaftarPesanan = findViewById(R.id.rv_daftarPesanan);
        layoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
    }

    @Override
    public void initEvent() {
        rvDaftarPesanan.setHasFixedSize(true);
        rvDaftarPesanan.setLayoutManager(layoutManager);
        presenter.daftarPesanan();
    }

    @Override
    public void loadData(List<DaftarPesananModel> item) {
        adapter = new DaftarPesananAdapter(item, mContext);
        rvDaftarPesanan.setAdapter(adapter);
        adapter.setOnItemClick(new DaftarPesananAdapter.onItemClickListerner() {
            @Override
            public void onClick(int Position, DaftarPesananModel model) {
                Toast.makeText(mContext,Position+" "+ model.getKodeTransaksi(), Toast.LENGTH_SHORT).show();
                PindahActivity.pindahActivity(mContext,DetailDaftarPesananActivity.class);
            }
        });

    }

    @Override
    public void tampilLoading() {

    }

    @Override
    public void tampilPesan(String message) {

        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

    }
}
