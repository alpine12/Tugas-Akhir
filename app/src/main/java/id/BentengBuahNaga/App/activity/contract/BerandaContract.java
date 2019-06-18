package id.BentengBuahNaga.App.activity.contract;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public interface BerandaContract {
    interface Model {
    }

    interface View {
        void initViewPager();

        void initBottomNav();
    }

    interface Presenter {
        void setViewPager();

        void setBottomnav();
    }
}
