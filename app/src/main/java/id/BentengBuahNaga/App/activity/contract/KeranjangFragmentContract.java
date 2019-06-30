package id.BentengBuahNaga.App.activity.contract;

import java.util.HashMap;
import java.util.List;

import id.BentengBuahNaga.App.activity.fragment.KeranjangFragment;
import id.BentengBuahNaga.App.activity.model.KeranjangFragmentModel;
import id.BentengBuahNaga.App.activity.model.PromoModel;

public interface KeranjangFragmentContract {
    interface Model {
    }

    interface View {

        void loadPesanan(List<KeranjangFragmentModel> item);

        void kodePromo(PromoModel item);

        void viewKeranjang();

        void hideKeranjang();

        void totalPesanan(String total, int diskon);

        void tampilLoading();

        void tutupLoading();

        void tampilPesan(String pesan);

        void buttonOnclick();

        void tampilDialogSukses(String title, String pesan);

        void tampilDialogGagal(String title, String pesan);
    }

    interface Presenter {

        void daftarKeranjang(String id);

        void kodePromo(String kode);

        void totalPesanan(List<KeranjangFragmentModel> item, int diskon);

        void bayarPesnan(HashMap<String, String> data, String id,List<KeranjangFragmentModel> item);

        void onCLick();
    }
}
