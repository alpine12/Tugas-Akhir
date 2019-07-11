package id.BentengBuahNaga.App.activity.contract;

import java.util.List;

import id.BentengBuahNaga.App.activity.model.BerandaFragmentModel;

public interface BerandaFragmenContract {
    interface Model {
    }

    interface View {

        void initView();

        void initEvent();

        void loadBanner(List<BerandaFragmentModel> item);
    }

    interface Presenter {

        void initMain();

        void getBanner();
    }
}
