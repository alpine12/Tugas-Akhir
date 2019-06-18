package id.BentengBuahNaga.App.activity.presenter;

import android.util.Log;

import java.util.HashMap;

import id.BentengBuahNaga.App.activity.contract.RegisterContract;
import id.BentengBuahNaga.App.activity.ResponseModel.ResponseRegister;
import id.BentengBuahNaga.App.activity.model.RegisterModel;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.Presenter {
    private static final String TAG = "RegisterPresenter";
    private RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void tombolMendaftar(HashMap<String,String> data) {
        Log.d(TAG, "tombolMendaftar: click ");
        mendaftar(data);

    }

    private void mendaftar(HashMap<String,String> data){
        Call<ResponseRegister> Register = InitRetrofit.getInstance().Register(data);
        Register.enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {

                if (response.isSuccessful()){
                    ResponseRegister res = response.body();
                    boolean isTrue;
                    if (res.isStatus()){
                        view.berhasilmendaftar(res.getMessage());
                    }else {
                        view.gagalMendaftar(res.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                view.jaringanGagal();
            }
        });
    }
}
