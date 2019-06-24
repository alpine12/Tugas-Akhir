package id.BentengBuahNaga.App.activity.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.BerandaContract;
import id.BentengBuahNaga.App.activity.contract.BerandaFragmenContract;
import id.BentengBuahNaga.App.activity.presenter.BerandaFragmenPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment implements BerandaFragmenContract.View {
    private static final String TAG = "BerandaFragment";
   private CarouselView banner;
    private CarouselView makanan;
    private CarouselView minuman;
    private CarouselView snack;
    private BerandaFragmenPresenter presenter;

    private int[] imgBanner;
    private int[] imgMakanan;
    private int[] imgMinuman;
    private int[] imgSnack;


    public BerandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        initUi(view);
        intitEvent();
        return view;
    }

    private void initUi(View view) {
        presenter = new BerandaFragmenPresenter(this);
        banner = view.findViewById(R.id.banner);
        makanan = view.findViewById(R.id.makanan);
        minuman = view.findViewById(R.id.minuman);
        snack = view.findViewById(R.id.snack);
    }

    private void intitEvent() {
        presenter.initbanner();

    }

    @Override
    public void loadBanner(int[] data1, int[] data2, int[] data3, int[] data4) {
        imgBanner = data1;
        imgMakanan = data2;
        imgMinuman = data3;
        imgSnack = data4;
        banner.setPageCount(imgMakanan.length);
        banner.setImageListener(imageListenerSnack);
        banner.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {

            }
        });
//        makanan.setPageCount(imgMakanan.length);
//        makanan.setImageListener(imageListenerMakanan);
//        minuman.setPageCount(imgMinuman.length);
//        minuman.setImageListener(imageListenerMinuman);
//        snack.setPageCount(imgSnack.length);
//        snack.setImageListener(imageListenerSnack);

    }

    ImageListener imageListenerBanner = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(imgBanner[position]);
        }
    };

    ImageListener imageListenerMakanan = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(imgMakanan[position]);
        }
    };

    ImageListener imageListenerMinuman = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(imgMinuman[position]);
        }
    };

    ImageListener imageListenerSnack = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(imgSnack[position]);
        }
    };
}
