package id.BentengBuahNaga.App.activity.presenter;

import id.BentengBuahNaga.App.activity.contract.LoginContract;
import id.BentengBuahNaga.App.activity.contract.RegisterContract;

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void tombolMendaftar() {

        view.berhasilmendaftar();
        
    }
}
