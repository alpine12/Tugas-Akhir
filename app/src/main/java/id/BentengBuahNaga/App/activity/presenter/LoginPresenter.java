package id.BentengBuahNaga.App.activity.presenter;

import android.text.TextUtils;

import id.BentengBuahNaga.App.activity.contract.LoginContract;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void cekLogin(String username) {
        String user = "aaa";
        if (TextUtils.isEmpty(username)) {
            view.loginGagal();
        } else if (!username.equals(user)) {
            view.usernameSalah();
        } else {
           view.loginBerhasil();
        }
    }

    @Override
    public void tombolDaftar() {
        view.MasukHalamanDaftar();
    }
}
