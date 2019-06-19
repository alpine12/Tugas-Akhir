package id.BentengBuahNaga.App.activity.presenter;

import id.BentengBuahNaga.App.activity.contract.MenuFragmentContract;

public class MenuFragmentPresenter implements MenuFragmentContract.Presenter {
    MenuFragmentContract.View view;

    public MenuFragmentPresenter(MenuFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void initPelanggan() {
        view.initPelanggan();
    }

    @Override
    public void tombolQrCode() {
        view.showQRcodeScanner();
    }

    @Override
    public void tombolMakanan() {
        view.daftarMakanan();
    }

    @Override
    public void tombolMinuman() {
        view.daftarMinuman();
    }

    @Override
    public void tombolSnack() {
        view.daftarSnack();
    }

    @Override
    public void tombolDaftarPesanan() {
        view.daftarPesanan();
    }

    @Override
    public void PermCamera() {
        view.PermOpenCamera();
    }
}
