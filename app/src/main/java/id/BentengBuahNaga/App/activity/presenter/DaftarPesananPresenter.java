package id.BentengBuahNaga.App.activity.presenter;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.List;

import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDeffault;
import id.BentengBuahNaga.App.activity.contract.DaftarPesananContract;
import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;
import id.BentengBuahNaga.App.helper.SharedPreff;
import id.BentengBuahNaga.App.network.InitRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarPesananPresenter implements DaftarPesananContract.Presenter {

    private DaftarPesananContract.View v;

    public DaftarPesananPresenter(DaftarPesananContract.View v) {
        this.v = v;
    }

    @Override
    public void initMain() {
        v.initView();
        v.initEvent();
    }

    @Override
    public void daftarPesanan() {
        String idPelanggan = Prefs.getString(SharedPreff.getIdPelanggan(), null);
        Call<ResponseDeffault> daftarPesanan = InitRetrofit.getInstance().getDaftarPesanan(idPelanggan);
        daftarPesanan.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();
                if (response.isSuccessful()) {
                    if (res.isStatus()) {
                        List<DaftarPesananModel> item = res.getDaftarPesaan();
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
