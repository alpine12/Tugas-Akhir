package id.BentengBuahNaga.App.activity.presenter;

import id.BentengBuahNaga.App.activity.contract.BerandaContract;

public class BerandaPresenter implements BerandaContract.Presenter {
    private static final String TAG = "BerandaPresenter";

    private BerandaContract.View view;

    public BerandaPresenter(BerandaContract.View view) {
        this.view = view;
    }

    @Override
    public void setViewPager() {
        view.initViewPager();
    }

    @Override
    public void setBottomnav() {
        view.initBottomNav();
    }
}
