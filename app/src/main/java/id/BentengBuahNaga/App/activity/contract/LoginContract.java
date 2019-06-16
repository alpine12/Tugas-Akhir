package id.BentengBuahNaga.App.activity.contract;

public interface LoginContract {
    interface Model {

        String getUsername();
    }

    interface View {

        void loginBerhasil();

        void loginGagal();
    }

    interface Presenter {

        void cekLogin();
    }
}
