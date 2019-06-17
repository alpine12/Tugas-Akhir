package id.BentengBuahNaga.App.activity.contract;

public interface LoginContract {
    interface Model {


    }

    interface View {

        void loginBerhasil();

        void loginGagal();

        void usernameSalah();

        void MasukHalamanDaftar();
    }

    interface Presenter {

        void cekLogin(String username);

        void tombolDaftar();

    }
}
