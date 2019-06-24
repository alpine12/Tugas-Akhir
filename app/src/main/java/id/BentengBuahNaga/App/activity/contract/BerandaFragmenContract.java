package id.BentengBuahNaga.App.activity.contract;

public interface BerandaFragmenContract {
    interface Model {
    }

    interface View {

        void loadBanner(int[] data1, int[] data2, int[] data3, int[] data4);
    }

    interface Presenter {

        void initbanner();
    }
}
