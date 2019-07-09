package id.BentengBuahNaga.App.activity.contract;

import java.util.List;

import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;

public interface HistoryTransasksiContract {
    interface Model {
    }

    interface View {

        void initUi();

        void initEvent();

        void loadHistoryPesnana(List<DaftarPesananModel> item);

        void tampilPesan(String pesan);
    }

    interface Presenter {

        void initMain();

        void getHistoryPesanan();
    }
}
