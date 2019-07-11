package id.BentengBuahNaga.App.activity.presenter;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDeffault;
import id.BentengBuahNaga.App.activity.contract.BerandaFragmenContract;
import id.BentengBuahNaga.App.activity.model.BerandaFragmentModel;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BerandaFragmenPresenter implements BerandaFragmenContract.Presenter {

    private BerandaFragmenContract.View view;

    public BerandaFragmenPresenter(BerandaFragmenContract.View view) {
        this.view = view;
    }

    @Override
    public void initMain() {
        view.initView();
        view.initEvent();
    }

    @Override
    public void getBanner() {
        Call<ResponseDeffault> banner = InitRetrofit.getInstance().banner();
        banner.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();
                if (response.isSuccessful() && res!=null){
                    if (res.isStatus()){
                        List<BerandaFragmentModel> item = res.getBanner();
                        view.loadBanner(item);
                    }else {

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDeffault> call, Throwable t) {

            }
        });
    }
}
