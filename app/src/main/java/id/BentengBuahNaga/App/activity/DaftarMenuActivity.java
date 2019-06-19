package id.BentengBuahNaga.App.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.adapter.DaftarMenuAdapter;
import id.BentengBuahNaga.App.activity.contract.DaftarMenuContract;
import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;
import id.BentengBuahNaga.App.activity.presenter.DaftarMenuPresenter;
import id.BentengBuahNaga.App.utils.PindahActivity;

public class DaftarMenuActivity extends AppCompatActivity implements DaftarMenuContract.View {
    private static final String TAG = "DaftarMenuActivity";
    private RecyclerView rvMenu;
    private DaftarMenuPresenter presenter;
    private GridLayoutManager layoutManager;
    private DaftarMenuAdapter adapter;
    private Context mContext;
    private ShimmerFrameLayout mShimmerViewContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);

        initUi();
        initEvent();
    }

    public void initUi() {
        mContext = this;
        presenter = new DaftarMenuPresenter(this);
        rvMenu = findViewById(R.id.rv_daftarMenu);
        layoutManager = new GridLayoutManager(this,2);
        mShimmerViewContainer = findViewById(R.id.loadingContainer);
    }

    private void initEvent() {
        rvMenu.setLayoutManager(layoutManager);
        rvMenu.setHasFixedSize(true);
        rvMenu.setItemAnimator(new DefaultItemAnimator());

        String id = getIntent().getStringExtra("param");
        presenter.getMenu(id);
    }

    @Override
    public void stopShimmerLoading() {
        mShimmerViewContainer.stopShimmer();
        mShimmerViewContainer.setVisibility(View.GONE);
    }

    @Override
    public void loadMenu(List<DaftarMenuModel> menu) {
        adapter = new DaftarMenuAdapter(menu, mContext, new DaftarMenuAdapter.onClickListerner() {
            @Override
            public void onItemClick(DaftarMenuModel item) {
                PindahActivity.pindahActivityParam(mContext, DetailMenuTampilan.class, item.getIdMenu());
            }
        });
        rvMenu.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mShimmerViewContainer.stopShimmer();
    }

    @Override
    protected void onPause() {
        mShimmerViewContainer.stopShimmer();
        super.onPause();
    }
}
