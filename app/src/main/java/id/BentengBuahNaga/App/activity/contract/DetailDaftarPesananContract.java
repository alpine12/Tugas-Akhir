package id.BentengBuahNaga.App.activity.contract;

import java.util.List;

import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;
import id.BentengBuahNaga.App.activity.model.DetailDaftarPesananModel;

public interface DetailDaftarPesananContract {
    interface Model {
    }

    interface View {

        void initView();

        void initEvent();

        void loadData( List<DetailDaftarPesananModel> item);

        void tampilLoading();

        void tampilPesan(String message);
    }

    interface Presenter {

        void initMain();

        void daftarPesanan(String idPesanan);
    }
}
