package id.BentengBuahNaga.App.activity.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.adapter.SliderImageBerandaAdapter;
import id.BentengBuahNaga.App.activity.contract.BerandaFragmenContract;
import id.BentengBuahNaga.App.activity.model.BerandaFragmentModel;
import id.BentengBuahNaga.App.activity.presenter.BerandaFragmenPresenter;

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



    public BerandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        presenter = new BerandaFragmenPresenter(this);
        sliderView = view.findViewById(R.id.makanan);
        presenter.initMain();

        v = view;

        return view;
    }
    @Override
    public void initView() {
        mContext = getActivity();

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
}
