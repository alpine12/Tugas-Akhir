package id.BentengBuahNaga.App.activity.contract;

import java.util.List;

import id.BentengBuahNaga.App.activity.model.DetailDaftarPesananModel;

public interface DetailHistoryTransaksiContract {
    interface Model {
    }

    interface View {
        void initUi();
        
        void initEvent();
        
        void loadData(List<DetailDaftarPesananModel> item);
        
        void tampilPesan(String pesan);
    }

    interface Presenter {
        
        void intMain();
        
        void getPesanan(String idPesanan);
    }
}
