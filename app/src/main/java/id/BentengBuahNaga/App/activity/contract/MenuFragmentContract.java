package id.BentengBuahNaga.App.activity.contract;

public interface MenuFragmentContract {
    interface Model {
    }

    interface View {
        void initPelanggan();

        void showQRcodeScanner();

        void daftarMakanan();

        void daftarMinuman();

        void daftarSnack();

        void daftarPesanan();

        void PermOpenCamera();

        void pesanKodeMejaKososng();

    }

    interface Presenter {

        void initPelanggan();

        void tombolQrCode();

        void tombolMakanan();

        void tombolMinuman();

        void tombolSnack();

        void tombolDaftarPesanan();

        void PermCamera();

        void cekmejaKososng();

    }
}
