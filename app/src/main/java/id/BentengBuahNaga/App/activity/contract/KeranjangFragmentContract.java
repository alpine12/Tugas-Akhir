package id.BentengBuahNaga.App.activity.contract;

import java.util.HashMap;
import java.util.List;

import id.BentengBuahNaga.App.activity.fragment.KeranjangFragment;
import id.BentengBuahNaga.App.activity.model.KeranjangFragmentModel;

public interface KeranjangFragmentContract {
    interface Model {
    }

    interface View {

        void loadPesanan(List<KeranjangFragmentModel> item);

        void viewKeranjang();

        void hideKeranjang();

        void totalPesanan(String total);

        void tampilLoading();

        void tutupLoading();

        void tampilPesan(String pesan);

        void buttonOnclick();
    }

    interface Presenter {

        void daftarKeranjang(String id);

        void totalPesanan(List<KeranjangFragmentModel> item);

        void bayarPesnan(HashMap<String, String> data, String id,List<KeranjangFragmentModel> item);

        void onCLick();
    }
}
