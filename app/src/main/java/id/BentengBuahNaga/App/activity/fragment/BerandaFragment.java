package id.BentengBuahNaga.App.activity.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.DetailMenuTampilan;
import id.BentengBuahNaga.App.activity.adapter.SliderImageBerandaAdapter;
import id.BentengBuahNaga.App.activity.contract.BerandaFragmenContract;
import id.BentengBuahNaga.App.activity.model.BerandaFragmentModel;
import id.BentengBuahNaga.App.activity.model.MenuFavoritModel;
import id.BentengBuahNaga.App.activity.presenter.BerandaFragmenPresenter;
import id.BentengBuahNaga.App.helper.FormatRp;
import id.BentengBuahNaga.App.network.InitRetrofit;
import id.BentengBuahNaga.App.utils.PindahActivity;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment implements BerandaFragmenContract.View {
    private static final String TAG = "BerandaFragment";

    private SliderView sliderView;
    private BerandaFragmenPresenter presenter;
    private Context mContext;
    private SliderImageBerandaAdapter adapter;
    private View v;
    private ImageView iconMakanan;
    private ImageView iconMinuman;
    private ImageView iconSnack;
    private TextView titleManakan;
    private TextView hargaMakanan;
    private TextView titleMinuman;
    private TextView hargaMinuman;
    private TextView titleSnack;
    private TextView hargaSnack;
    private FancyButton detailMakanan;
    private FancyButton detailMinuman;
    private FancyButton detailSnack;

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        v = view;
        presenter = new BerandaFragmenPresenter(this);

        presenter.initMain();



        return view;
    }
    @Override
    public void initView() {
        mContext = getActivity();
        sliderView = v.findViewById(R.id.makanan);
        iconMakanan = v.findViewById(R.id.icon_makanan);
        iconMinuman = v.findViewById(R.id.icon_minuman);
        iconSnack = v.findViewById(R.id.icon_snack);
        titleManakan = v.findViewById(R.id.title_makanan);
        titleMinuman = v.findViewById(R.id.title_minuman);
        titleSnack = v.findViewById(R.id.title_snack);
        hargaMakanan = v.findViewById(R.id.harga_makanan);
        hargaMinuman = v.findViewById(R.id.harga_minuman);
        hargaSnack = v.findViewById(R.id.harga_snack);
        detailMakanan = v.findViewById(R.id.btn_pesan_makanan);
        detailMinuman = v.findViewById(R.id.btn_pesan_minuman);
        detailSnack = v.findViewById(R.id.btn_pesan_snack);
    }

    @Override
    public void initEvent() {
        sliderView.getChildCount();
        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        presenter.getBanner();
    }

    @Override
    public void loadBanner(List<BerandaFragmentModel> item) {

        adapter = new SliderImageBerandaAdapter(mContext,item);
        sliderView.setSliderAdapter(adapter);
    }

    @Override
    public void loadFavorit(List<MenuFavoritModel> item) {

        for (int i = 0; i < item.size(); i++) {
            MenuFavoritModel model = item.get(i);
            String kategori = item.get(i).getKategori();
            switch (kategori) {
                case "1" :
                    Picasso.get().load(InitRetrofit.getIMAGEURL()+model.getGambar()).fit()
                            .into(iconMakanan);
                    titleManakan.setText(model.getNamaMenu());
                    hargaMakanan.setText(FormatRp.FormatRp(model.getHarga()));
                    detailMakanan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            PindahActivity.pindahActivityParam(mContext, DetailMenuTampilan.class, model.getIdMenu());
                        }
                    });
                    break;


                case "2" :

                    Picasso.get().load(InitRetrofit.getIMAGEURL()+model.getGambar()).fit()
                            .into(iconMinuman);
                    titleMinuman.setText(model.getNamaMenu());
                    hargaMinuman.setText(FormatRp.FormatRp(model.getHarga()));
                    detailMinuman.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            PindahActivity.pindahActivityParam(mContext, DetailMenuTampilan.class, model.getIdMenu());
                        }
                    });
                    break;

                case "3":
                    Picasso.get().load(InitRetrofit.getIMAGEURL()+model.getGambar()).fit()
                            .into(iconSnack);
                    titleSnack.setText(model.getNamaMenu());
                    hargaSnack.setText(FormatRp.FormatRp(model.getHarga()));
                    detailSnack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            PindahActivity.pindahActivityParam(mContext, DetailMenuTampilan.class, model.getIdMenu());
                        }
                    });
                    break;
            }
        }

    }
}
