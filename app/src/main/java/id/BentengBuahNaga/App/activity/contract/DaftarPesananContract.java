package id.BentengBuahNaga.App.activity.contract;

import java.util.List;

import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;

public interface DaftarPesananContract {
    interface Model {
    }

    interface View {

        void initView();

        void initEvent();

        void loadData(List<DaftarPesananModel> item);

        void dismisRefresh();

        void tampilPesan(String message);
    }

    interface Presenter {

        void initMain();

        void daftarPesanan();
    }
}
