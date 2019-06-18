package id.BentengBuahNaga.App.activity.contract;

import java.util.HashMap;

import id.BentengBuahNaga.App.activity.model.RegisterModel;

public interface RegisterContract {
    interface Model {
         String getToken();

         String getNamaPengguna();

         String getNamaLengkap();

         String getTanggalLahir();

         String getNoHp();

         String getPekerjaan();

         String getAlamat();

    }

    interface View {

        void berhasilmendaftar(String message);

        void gagalMendaftar(String message);

        void jaringanGagal();

    }

    interface Presenter {

        void tombolMendaftar(HashMap<String, String> data);

    }
}
