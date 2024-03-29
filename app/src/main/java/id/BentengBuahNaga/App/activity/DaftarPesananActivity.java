package id.BentengBuahNaga.App.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
    private ImageButton back;
    private TextView title;
    private SwipeRefreshLayout swipeRefreshLayout;

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
        back = findViewById(R.id.backArrow);
        title = findViewById(R.id.title_toolbar);
        rvDaftarPesanan = findViewById(R.id.rv_daftarPesanan);
        layoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
    }

    @Override
    public void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title.setText("Daftar Transaksi");
        rvDaftarPesanan.setHasFixedSize(true);
        rvDaftarPesanan.setLayoutManager(layoutManager);
        presenter.daftarPesanan();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);

                presenter.daftarPesanan();
            }
        });
    }

    @Override
    public void loadData(List<DaftarPesananModel> item) {
        adapter = new DaftarPesananAdapter(item, mContext);
        rvDaftarPesanan.setAdapter(adapter);
        adapter.setOnItemClick(new DaftarPesananAdapter.onItemClickListerner() {
            @Override
            public void onClick(int Position, DaftarPesananModel model) {
                Toast.makeText(mContext,Position+" "+ model.getKodeTransaksi(), Toast.LENGTH_SHORT).show();
                PindahActivity.pindahActivityParam(mContext,DetailDaftarPesananActivity.class,model.getIdPesanan());
            }
        });

    }

    @Override
    public void dismisRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void tampilPesan(String message) {

        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

    }
}
