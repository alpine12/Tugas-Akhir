package id.BentengBuahNaga.App.activity.presenter;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDaftarMenu;
import id.BentengBuahNaga.App.activity.contract.DetailMenuTampilanContract;
import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMenuTampilanPresenter implements DetailMenuTampilanContract.Presenter {

    private DetailMenuTampilanContract.View view;

    public DetailMenuTampilanPresenter(DetailMenuTampilanContract.View view) {
        this.view = view;
    }

    @Override
    public void bindItem(String id) {

        Call<ResponseDaftarMenu> menu = InitRetrofit.getInstance().deatailMenu(id);
        menu.enqueue(new Callback<ResponseDaftarMenu>() {
            @Override
            public void onResponse(Call<ResponseDaftarMenu> call, Response<ResponseDaftarMenu> response) {
                ResponseDaftarMenu res = response.body();
                if (response.isSuccessful()){
                    if (res.isStatus()){
                        DaftarMenuModel menu = res.getMenu();
                        view.loadItem(menu);
                        view.loadingItem();
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
