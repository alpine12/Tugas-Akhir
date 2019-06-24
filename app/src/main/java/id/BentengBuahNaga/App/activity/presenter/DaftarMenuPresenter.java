package id.BentengBuahNaga.App.activity.presenter;

import java.util.List;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDeffault;
import id.BentengBuahNaga.App.activity.contract.DaftarMenuContract;
import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarMenuPresenter implements DaftarMenuContract.Presenter {
    DaftarMenuContract.View view;

    public DaftarMenuPresenter(DaftarMenuContract.View view) {
        this.view = view;
    }

    @Override
    public void getMenu(String id) {
        Call<ResponseDeffault> menu = InitRetrofit.getInstance().daftarMenu(id);
        menu.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();
                if (response.isSuccessful()){
                    if (res.isStatus()){
                        List<DaftarMenuModel> list = res.getDaftarmenu();
                        view.loadMenu(list);
                        view.stopShimmerLoading();
                        view.showMessage(res.getMessage());
                    }else {
                        view.showMessage(res.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDeffault> call, Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }
}
