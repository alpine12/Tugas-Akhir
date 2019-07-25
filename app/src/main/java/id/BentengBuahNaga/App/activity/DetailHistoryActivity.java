package id.BentengBuahNaga.App.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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
import id.BentengBuahNaga.App.helper.FormatRp;
import mehdi.sakout.fancybuttons.FancyButton;

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
    private ImageButton back;
    private TextView tittle;
    private FancyButton cetak;


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
        back = findViewById(R.id.backArrow);
        tittle = findViewById(R.id.title_toolbar);
        kodeTrans = findViewById(R.id.tv_kodeTransaksi);
        total = findViewById(R.id.tv_totalBayar);
        tggljam = findViewById(R.id.tv_tggljamPesan);
        status = findViewById(R.id.tv_statusBayar);

        cetak = findViewById(R.id.btn_cetakInvoice);
        rvDaftarPesanan = findViewById(R.id.recyclerview);
    }

    @Override
    public void initEvent() {
        tittle.setText("Detail Transaksi");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        String data = getIntent().getStringExtra("param");
        Gson gson = new Gson();
        DaftarPesananModel item = gson.fromJson(data, DaftarPesananModel.class);
        kodeTrans.setText(" : "+item.getKodeTransaksi());

        int potongan = 0;
        if (item.getKodePromo().equals("null")) {
            potongan = Integer.valueOf(item.getTotalPembayaran());
        } else {
            int total_bayar = Integer.parseInt(item.getTotalPembayaran());
            int diskon = Integer.parseInt(item.getPotongan());
            potongan = (total_bayar - ((total_bayar * diskon) / 100));
        }

        total.setText(" : "+ FormatRp.FormatRp(String.valueOf(potongan)));
        tggljam.setText(" : "+item.getWaktuTransaksi());
        status.setText(" : "+"Pembayaran telah diterima");
        rvDaftarPesanan.setHasFixedSize(true);
        rvDaftarPesanan.setLayoutManager(new LinearLayoutManager(this));
        presenter.getPesanan(item.getIdPesanan());

        cetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String URL = "http://google.com";
                    Uri webpage = Uri.parse(URL);
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(mContext, "No application can handle this request. Please install a web browser or check your URL.",  Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

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
