package id.BentengBuahNaga.App.activity.contract;

import java.util.HashMap;

import id.BentengBuahNaga.App.activity.model.DetailAkunModel;

public interface DetailAkunContract {
    interface Model {
    }

    interface View {

        void initView();

        void initEvent();

        void tampilpesan(String pesan);
    }

    interface Presenter {

        void initMain();

        void updatePengguna(HashMap<String, String> data);
    }
}
