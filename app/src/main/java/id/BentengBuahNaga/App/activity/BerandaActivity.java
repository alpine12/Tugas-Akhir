package id.BentengBuahNaga.App.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.BerandaContract;
import id.BentengBuahNaga.App.activity.fragment.AkunFragment;
import id.BentengBuahNaga.App.activity.fragment.BerandaFragment;
import id.BentengBuahNaga.App.activity.fragment.KeranjangFragment;
import id.BentengBuahNaga.App.activity.fragment.MenuFragment;
import id.BentengBuahNaga.App.activity.presenter.BerandaPresenter;
import id.BentengBuahNaga.App.activity.viewpager_adapter.SectionPageAdapter;

public class BerandaActivity extends AppCompatActivity implements BerandaContract.View {
    private static final String TAG = "BerandaActivity";
    private BerandaPresenter presenter;
    private BottomNavigationViewEx bottomNav;
    private ViewPager viewPager;
    private SectionPageAdapter viewPageradapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        initUi();
        initEvent();
    }

    private void initUi() {
        presenter = new BerandaPresenter(this);
        viewPager = findViewById(R.id.pager);
        bottomNav = findViewById(R.id.bnve);
        viewPageradapter = new SectionPageAdapter(getSupportFragmentManager());
    }

    private void initEvent() {
       presenter.setViewPager();
       presenter.setBottomnav();
    }

    @Override
    public void initViewPager() {
        viewPager.setOffscreenPageLimit(4);
        MenuFragment menu = new MenuFragment();
        BerandaFragment beranda = new BerandaFragment();
        KeranjangFragment cart = new KeranjangFragment();
        AkunFragment akun = new AkunFragment();

        viewPageradapter.addFragmen(beranda);
        viewPageradapter.addFragmen(menu);
        viewPageradapter.addFragmen(cart);
        viewPageradapter.addFragmen(akun);
        viewPager.setAdapter(viewPageradapter);
        bottomNav.setupWithViewPager(viewPager);

    }

    @Override
    public void initBottomNav() {
        bottomNav.enableAnimation(false);
        bottomNav.enableShiftingMode(false);
        bottomNav.enableItemShiftingMode(false);
        bottomNav.setOnNavigationItemSelectedListener(listener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {
                        case R.id.beranda:
                            viewPager.setCurrentItem(0);
                            break;
                        case R.id.menu:
                            viewPager.setCurrentItem(1);
                            break;
                        case R.id.kerangjang:
                            viewPager.setCurrentItem(2);
                            break;
                        case R.id.akun:
                            viewPager.setCurrentItem(3);
                            break;
                    }
                    return true;
                }
            };
}
