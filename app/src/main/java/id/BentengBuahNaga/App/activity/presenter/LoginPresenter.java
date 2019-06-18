package id.BentengBuahNaga.App.activity.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import id.BentengBuahNaga.App.activity.contract.LoginContract;

public class LoginPresenter implements LoginContract.Presenter {
    private static final String TAG = "LoginPresenter";
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
//            FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener((Activity) view, new OnCompleteListener<InstanceIdResult>() {
//                @Override
//                public void onComplete(@NonNull Task<InstanceIdResult> task) {
//                   String token = task.getResult().getToken();
//                    Log.d(TAG, "onComplete: "+token);
//                }
//            });

        }
    }

    @Override
    public void tombolDaftar() {
        view.MasukHalamanDaftar();
    }


}
