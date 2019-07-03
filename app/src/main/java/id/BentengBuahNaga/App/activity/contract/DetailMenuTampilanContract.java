package id.BentengBuahNaga.App.activity.contract;

import java.util.HashMap;

import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;

public interface DetailMenuTampilanContract {
    interface Model {
    }

    interface View {
        void loadingItem();

        void loadItem(DaftarMenuModel menu);

        void tampilDialogPesan(String titel, String pesan);

        void tampilNotif(String Message);
    }

    interface Presenter {

        void bindItem(String id);

        void tambahKeranang(HashMap<String, String> data);
    }
}
