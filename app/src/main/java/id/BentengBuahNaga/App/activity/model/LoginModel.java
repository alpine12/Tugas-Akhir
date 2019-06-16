package id.BentengBuahNaga.App.activity.model;

import android.text.TextUtils;

import id.BentengBuahNaga.App.activity.contract.LoginContract;

public class LoginModel implements LoginContract.Model {

    String username;




    public LoginModel(String username) {
        this.username = username;
    }


}
