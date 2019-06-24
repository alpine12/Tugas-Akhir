package id.BentengBuahNaga.App.activity.presenter;

import java.util.HashMap;
import java.util.List;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDeffault;
import id.BentengBuahNaga.App.activity.contract.KeranjangFragmentContract;
import id.BentengBuahNaga.App.activity.fragment.KeranjangFragment;
import id.BentengBuahNaga.App.activity.model.KeranjangFragmentModel;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KeranjangFragmentPresenter implements KeranjangFragmentContract.Presenter {

    KeranjangFragmentContract.View view;

    public KeranjangFragmentPresenter(KeranjangFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void daftarKeranjang(String id) {
        Call<ResponseDeffault> getKeranjang = InitRetrofit.getInstance().getKeranjang(id);
        getKeranjang.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();
                if (response.isSuccessful()) {
                    if (res.isStatus()) {
                        List<KeranjangFragmentModel> item = res.getDaftarKeranjang();
                        view.loadPesanan(item);
                        view.tampilPesan(res.getMessage());
                        view.viewKeranjang();

                    }else {
                        view.tampilPesan(res.getMessage());
                        view.hideKeranjang();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDeffault> call, Throwable t) {
                view.tampilPesan(t.getMessage());
            }
        });
    }

    @Override
    public void totalPesanan(List<KeranjangFragmentModel> item) {

        int total = 0;
        for (int i = 0; i < item.size(); i++) {
            total += Integer.valueOf(item.get(i).getHarga());
        }
        view.totalPesanan(String.valueOf(total));
    }

    @Override
    public void bayarPesnan(HashMap<String, String> data, String id,List<KeranjangFragmentModel> item) {
        view.tampilLoading();
        Call<ResponseDeffault> bayar = InitRetrofit.getInstance().checkout(data);
        bayar.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();
                if (response.isSuccessful()) {
                    if (res.isStatus()) {
                        view.tampilPesan(res.getMessage());
                        deleteListKeranjang(id, item);
                        view.tutupLoading();
                    } else {
                        view.tampilPesan(res.getMessage());
                        view.tutupLoading();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDeffault> call, Throwable t) {
                view.tampilPesan(t.getMessage());
                view.tutupLoading();
            }
        });
    }

    private void deleteListKeranjang(String id, List<KeranjangFragmentModel> item){
        Call<ResponseDeffault> del = InitRetrofit.getInstance().deleteListKeranjang(id);
        del.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {

                view.hideKeranjang();
                view.tampilPesan(response.body().getMessage());

            }

            @Override
            public void onFailure(Call<ResponseDeffault> call, Throwable t) {
                view.tampilPesan(t.getMessage());
            }
        });
    }

    @Override
    public void onCLick() {
        view.buttonOnclick();
    }
}
