package id.BentengBuahNaga.App.activity.contract;

public interface AkunFragmenContract {
    interface Model {
    }

    interface View {
        void initUi();

        void initEvent();

    }

    interface Presenter {

       void initMain();
    }
}
