package id.BentengBuahNaga.App.activity.contract;

import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;

public interface DetailMenuTampilanContract {
    interface Model {
    }

    interface View {
        void loadingItem();

        void loadItem(DaftarMenuModel menu);
    }

    interface Presenter {

        void bindItem(String id);
    }
}
