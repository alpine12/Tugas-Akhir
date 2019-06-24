package id.BentengBuahNaga.App.activity.presenter;

import java.util.List;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDeffault;
import id.BentengBuahNaga.App.activity.contract.DetailDaftarPesananContract;
import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;
import id.BentengBuahNaga.App.activity.model.DetailDaftarPesananModel;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDaftarPesananPresenter implements DetailDaftarPesananContract.Presenter {

    DetailDaftarPesananContract.View v;

    public DetailDaftarPesananPresenter(DetailDaftarPesananContract.View v) {
        this.v = v;
    }

    @Override
    public void initMain() {
        v.initView();
        v.initEvent();
    }

    @Override
    public void daftarPesanan(String idPesanan) {
        Call<ResponseDeffault> daftarPesanan = InitRetrofit.getInstance().getDaftarPesanan(idPesanan);
        daftarPesanan.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();
                if (response.isSuccessful()) {
                    if (res.isStatus()) {
                        List<DetailDaftarPesananModel> item = res.getDaftarDetailPesaan();
                        v.loadData(item);
                        v.tampilPesan(res.getMessage());
                    } else {
                        v.tampilPesan(res.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDeffault> call, Throwable t) {
                v.tampilPesan(t.getMessage());
            }
        });
    }
}
