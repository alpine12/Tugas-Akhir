package id.BentengBuahNaga.App.activity.presenter;

import android.util.Log;

import java.util.HashMap;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDeffault;
import id.BentengBuahNaga.App.activity.contract.DetailMenuTampilanContract;
import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailMenuTampilanPresenter implements DetailMenuTampilanContract.Presenter {
    private static final String TAG = "DetailMenuTampilanPrese";
    private DetailMenuTampilanContract.View view;

    public DetailMenuTampilanPresenter(DetailMenuTampilanContract.View view) {
        this.view = view;
    }

    @Override
    public void bindItem(String id) {

        Call<ResponseDeffault> menu = InitRetrofit.getInstance().deatailMenu(id);
        menu.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();
                if (response.isSuccessful()) {
                    if (res.isStatus()) {
                        DaftarMenuModel menu = res.getMenu();
                        view.loadItem(menu);
                        view.loadingItem();
                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDeffault> call, Throwable t) {

            }
        });


    }

    @Override
    public void tambahKeranang(HashMap<String, String> data) {
        Call<ResponseDeffault> insertKeranjang = InitRetrofit.getInstance().tambahKeranjang(data);
        insertKeranjang.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();

                if (response.isSuccessful()) {
                    if (res.isStatus()) {
                        view.tampilNotif(res.getMessage());
                    } else {
                        view.tampilNotif(res.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDeffault> call, Throwable t) {
                view.tampilNotif("error");
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });


//        AndroidNetworking.post(InitRetrofit.getBaseUrl()+"keranjang")
//                .addBodyParameter(data)
//                .setPriority(Priority.MEDIUM)
//                .setTag("Insert")
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            view.tampilNotif(response.getString("message"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        view.tampilNotif(anError.getMessage());
//                    }
//                });

    }
}
