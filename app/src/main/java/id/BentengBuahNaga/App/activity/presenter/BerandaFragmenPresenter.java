package id.BentengBuahNaga.App.activity.presenter;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.BerandaFragmenContract;

public class BerandaFragmenPresenter implements BerandaFragmenContract.Presenter {

    private BerandaFragmenContract.View view;
    int[] imgBanner = {R.drawable.banner, R.drawable.banner, R.drawable.banner};
    int[] imgMakanan = {R.drawable.nasi_goreng, R.drawable.nasi_goreng, R.drawable.nasi_goreng};
    int[] imgMinuman = {R.drawable.es_teh, R.drawable.es_teh, R.drawable.es_teh};
    int[] imgSnack = {R.drawable.lumpia, R.drawable.es_teh, R.drawable.nasi_goreng};

    public BerandaFragmenPresenter(BerandaFragmenContract.View view) {
        this.view = view;
    }


    @Override
    public void initbanner() {
        view.loadBanner(imgBanner,imgMakanan,imgMinuman,imgSnack);
    }
}
