package id.BentengBuahNaga.App.activity.presenter;

import android.util.Log;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.HashMap;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDeffault;
import id.BentengBuahNaga.App.activity.contract.DetailAkunContract;
import id.BentengBuahNaga.App.helper.SharedPreff;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailAkunPresenter implements DetailAkunContract.Presenter {
    private static final String TAG = "DetailAkunPresenter";
    private DetailAkunContract.View v;

    public DetailAkunPresenter(DetailAkunContract.View v) {
        this.v = v;
    }

    @Override
    public void initMain() {
        v.initView();
        v.initEvent();
    }

    @Override
    public void updatePengguna(HashMap<String, String> data) {
        Call<ResponseDeffault> update = InitRetrofit.getInstance().updateDataDiri(data);
        update.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();
                if (res.isStatus()) {
                    v.tampilpesan(res.getMessage());
                    updateDataDiri(data);
                } else {
                    v.tampilpesan(res.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseDeffault> call, Throwable t) {
                v.tampilpesan(t.getMessage());
            }
        });
    }
    
    private void updateDataDiri(HashMap<String,String > data){

        Prefs.putString(SharedPreff.getNamaLengkap(), data.get("a"));
        Prefs.putString(SharedPreff.getTanggalLahir(), data.get("b"));
        Prefs.putString(SharedPreff.getNoHp(),data.get("c"));
        Prefs.putString(SharedPreff.getPekerjaan(), data.get("d"));
        Prefs.putString(SharedPreff.getAlamat(),data.get("e"));
    }


}
