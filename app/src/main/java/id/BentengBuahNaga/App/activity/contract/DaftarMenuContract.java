package id.BentengBuahNaga.App.activity.contract;

import java.util.List;

import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;

public interface DaftarMenuContract {
    interface Model {
    }

    interface View {
        void stopShimmerLoading();

        void loadMenu(List<DaftarMenuModel> menu);
    }

    interface Presenter {
        void getMenu(String id);
    }
}
