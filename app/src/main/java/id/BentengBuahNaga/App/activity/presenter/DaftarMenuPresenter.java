package id.BentengBuahNaga.App.activity.presenter;

import java.util.List;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDaftarMenu;
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
        Call<ResponseDaftarMenu> menu = InitRetrofit.getInstance().daftarMenu(id);
        menu.enqueue(new Callback<ResponseDaftarMenu>() {
            @Override
            public void onResponse(Call<ResponseDaftarMenu> call, Response<ResponseDaftarMenu> response) {
                ResponseDaftarMenu res = response.body();
                if (response.isSuccessful()){
                    if (res.isStatus()){
                        List<DaftarMenuModel> list = res.getDaftarmenu();
                        view.loadMenu(list);
                        view.stopShimmerLoading();
                    }else {

                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseDaftarMenu> call, Throwable t) {

            }
        });
    }
}
