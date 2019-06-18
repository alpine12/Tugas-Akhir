package id.BentengBuahNaga.App.activity.contract;

public interface MenuFragmentContract {
    interface Model {
    }

    interface View {
        void daftarMakanan();

        void daftarMinuman();

        void daftarSnack();

        void daftarPesanan();

    }

    interface Presenter {

        void tombolMakanan();

        void tombolMinuman();

        void tombolSnack();

        void tombolDaftarPesanan();

    }
}
