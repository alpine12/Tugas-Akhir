package id.BentengBuahNaga.App.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.adapter.DaftarDetailPesananAdapter;
import id.BentengBuahNaga.App.activity.adapter.DaftarPesananAdapter;
import id.BentengBuahNaga.App.activity.contract.DetailHistoryTransaksiContract;
import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;
import id.BentengBuahNaga.App.activity.model.DetailDaftarPesananModel;
import id.BentengBuahNaga.App.activity.presenter.DetailHistoryTransaksiPresenter;

public class DetailHistoryActivity extends AppCompatActivity implements DetailHistoryTransaksiContract.View {
    private static final String TAG = "DetailHistoryActivity";
    private DetailHistoryTransaksiPresenter presenter;
    private RecyclerView rvDaftarPesanan;
    private TextView kodeTrans;
    private TextView total;
    private TextView tggljam;
    private TextView status;
    private TextView jumlah;
    private DaftarDetailPesananAdapter adapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);
        presenter = new DetailHistoryTransaksiPresenter(this);
        presenter.intMain();

    }

    @Override
    public void initUi() {
        mContext = this;
        kodeTrans = findViewById(R.id.tv_kodeTransaksi);
        total = findViewById(R.id.tv_totalBayar);
        tggljam = findViewById(R.id.tv_tggljamPesan);
        status = findViewById(R.id.tv_statusBayar);
        jumlah = findViewById(R.id.tv_jumlahPesanan);
        rvDaftarPesanan = findViewById(R.id.recyclerview);
    }

    @Override
    public void initEvent() {
        String data = getIntent().getStringExtra("param");
        Gson gson = new Gson();
        DaftarPesananModel item = gson.fromJson(data, DaftarPesananModel.class);
        kodeTrans.setText(item.getKodeTransaksi());
        total.setText(item.getTotalPembayaran());
        tggljam.setText(item.getWaktuTransaksi());
        status.setText("Pembayaran telah diterima");
        jumlah.setText("0");
        rvDaftarPesanan.setHasFixedSize(true);
        rvDaftarPesanan.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void loadData(List<DetailDaftarPesananModel> item) {
    adapter = new DaftarDetailPesananAdapter(mContext, item);
    rvDaftarPesanan.setAdapter(adapter);
    }

    @Override
    public void tampilPesan(String pesan) {
        Toast.makeText(mContext, pesan, Toast.LENGTH_SHORT).show();
    }
}
