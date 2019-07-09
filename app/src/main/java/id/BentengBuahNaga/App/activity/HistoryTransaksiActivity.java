package id.BentengBuahNaga.App.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.adapter.HistoryTransaksiAdapter;
import id.BentengBuahNaga.App.activity.contract.HistoryTransasksiContract;
import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;
import id.BentengBuahNaga.App.activity.presenter.HistoryTransasksiPresenter;
import id.BentengBuahNaga.App.utils.PindahActivity;

public class HistoryTransaksiActivity extends AppCompatActivity implements HistoryTransasksiContract.View {
    private static final String TAG = "HistoryTransaksiActivit";
    private RecyclerView rvHistoryPesanan;
    private HistoryTransasksiPresenter presenter;
    private Context mContext;
    private HistoryTransaksiAdapter adapter;
    private View emptyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_transaksi);

        presenter = new HistoryTransasksiPresenter(this);
        presenter.initMain();
    }

    @Override
    public void initUi() {
        mContext = this;
        rvHistoryPesanan = findViewById(R.id.recyclerview);
       emptyView = getLayoutInflater().inflate(R.layout.empety_view, (ViewGroup) rvHistoryPesanan.getParent(), false);

    }

    @Override
    public void initEvent() {
        rvHistoryPesanan.setHasFixedSize(true);
        rvHistoryPesanan.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HistoryTransaksiAdapter(R.layout.list_item_layout_daftarpesanan);
        rvHistoryPesanan.setAdapter(adapter);
        adapter.setEmptyView(emptyView);
    }

    @Override
    public void loadHistoryPesnana(List<DaftarPesananModel> item) {
            if (item.size()<1){
                adapter.setEmptyView(emptyView);
            }else {
                adapter.setNewData(item);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        DaftarPesananModel item = (DaftarPesananModel) adapter.getItem(position);
                        Gson gson = new Gson();
                        String data = gson.toJson(item);
                        PindahActivity.pindahActivityParam(mContext, DetailHistoryActivity.class, data);
                    }
                });
            }
    }

    @Override
    public void tampilPesan(String pesan) {
        Toast.makeText(mContext, pesan, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getHistoryPesanan();
    }
}
