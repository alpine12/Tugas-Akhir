package id.BentengBuahNaga.App.activity.presenter;

import id.BentengBuahNaga.App.activity.contract.AkunFragmenContract;

public class AkunFragmenPresenter implements AkunFragmenContract.Presenter {

    AkunFragmenContract.View v;

    public AkunFragmenPresenter(AkunFragmenContract.View v) {
        this.v = v;
    }


    @Override
    public void initMain() {
        v.initUi();
        v.initEvent();
    }
}
