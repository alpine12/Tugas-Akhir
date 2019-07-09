package id.BentengBuahNaga.App.activity.presenter;

import java.util.List;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDeffault;
import id.BentengBuahNaga.App.activity.contract.DetailHistoryTransaksiContract;
import id.BentengBuahNaga.App.activity.model.DetailDaftarPesananModel;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailHistoryTransaksiPresenter implements DetailHistoryTransaksiContract.Presenter {
    private static final String TAG = "DetailHistoryTransaksiP";
    private DetailHistoryTransaksiContract.View v;

    public DetailHistoryTransaksiPresenter(DetailHistoryTransaksiContract.View v) {
        this.v = v;
    }

    @Override
    public void intMain() {
        v.initUi();
        v.initEvent();
    }

    @Override
    public void getPesanan(String idPesanan) {
        Call<ResponseDeffault> pesanan = InitRetrofit.getInstance().detailPesanan9(idPesanan);
        pesanan.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();
                if (response.isSuccessful() && res != null) {
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
