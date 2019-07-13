package id.BentengBuahNaga.App.activity.presenter;

import id.BentengBuahNaga.App.activity.contract.DetailBannerContract;

public class DetailBannerPresenter implements DetailBannerContract.Presenter {
    private DetailBannerContract.View v;

    public DetailBannerPresenter(DetailBannerContract.View v) {
        this.v = v;
    }

    @Override
    public void initMain() {
        v.initView();
        v.initEvent();
    }
}
