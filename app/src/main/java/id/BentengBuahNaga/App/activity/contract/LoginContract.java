package id.BentengBuahNaga.App.activity.contract;

public interface LoginContract {
    interface Model {


    }

    interface View {

        void loginBerhasil(String message);

        void usernameSalah(String message);

        void loginGagal(String message);

        void MasukHalamanDaftar();
    }

    interface Presenter {

        void cekUsernameAda();

        void cekLogin(String username);

        void tombolDaftar();

    }
}
