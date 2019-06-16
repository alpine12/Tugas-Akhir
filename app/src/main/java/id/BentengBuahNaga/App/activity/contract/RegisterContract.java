package id.BentengBuahNaga.App.activity.contract;

public interface RegisterContract {
    interface Model {
    }

    interface View {

        void berhasilmendaftar();

        void gagalMendaftar();

    }

    interface Presenter {

        void tombolMendaftar();

    }
}
