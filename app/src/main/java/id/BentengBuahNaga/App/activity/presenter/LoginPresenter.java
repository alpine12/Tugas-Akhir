package id.BentengBuahNaga.App.activity.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.pixplicity.easyprefs.library.Prefs;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseLogin;
import id.BentengBuahNaga.App.activity.contract.LoginContract;
import id.BentengBuahNaga.App.activity.model.LoginModel;
import id.BentengBuahNaga.App.helper.SharedPreff;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {
    private static final String TAG = "LoginPresenter";
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void cekUsernameAda() {
        if (!Prefs.getString(SharedPreff.getNamaPengguna(), null).isEmpty()){
            view.loginBerhasil(Prefs.getString(SharedPreff.getNamaLengkap(), null));
        }

    }

    @Override
    public void cekLogin(String username) {

        if (TextUtils.isEmpty(username)){
            view.loginGagal("Nama Pengguna Tidak Boleh Kososng");
        }else {
            FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener((Activity) view, new OnCompleteListener<InstanceIdResult>() {
                @Override
                public void onComplete(@NonNull Task<InstanceIdResult> task) {
                   String token = task.getResult().getToken();
                    Log.d(TAG, "onComplete: "+token);
                    checkLoggin(username, token);
                }
            });
        }
    }

    @Override
    public void tombolDaftar() {
        view.MasukHalamanDaftar();
    }

    private void checkLoggin(String username, String token){
        Call<ResponseLogin> login = InitRetrofit.getInstance().login(username,token);
        login.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                ResponseLogin res = response.body();
                if (response.isSuccessful()){
                    if (res.isStatus()){
                        LoginModel model = res.getPengguna();
                        simpanSharedPreff(model);
                        view.loginBerhasil(res.getMessage());
                    }else {
                        view.usernameSalah(res.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                view.loginGagal(t.getMessage());
            }
        });
    }

    private void simpanSharedPreff(LoginModel model){

        Prefs.putString(SharedPreff.getIdPelanggan(), model.getIdPelanggan());
        Prefs.putString(SharedPreff.getNamaPengguna(), model.getNamaPengguna());
        Prefs.putString(SharedPreff.getNamaLengkap(), model.getNamaLengkap());
        Prefs.putString(SharedPreff.getNoHp(), model.getNoHp());
        Prefs.putString(SharedPreff.getTanggalLahir(), model.getTanggalLahir());
        Prefs.putString(SharedPreff.getAlamat(), model.getAlamat());

    }


}
