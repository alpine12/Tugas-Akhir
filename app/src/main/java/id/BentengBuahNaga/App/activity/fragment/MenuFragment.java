package id.BentengBuahNaga.App.activity.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.DaftarMenuActivity;
import id.BentengBuahNaga.App.activity.contract.MenuFragmentContract;
import id.BentengBuahNaga.App.activity.presenter.MenuFragmentPresenter;
import id.BentengBuahNaga.App.utils.PindahActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements MenuFragmentContract.View, View.OnClickListener {
    private MenuFragmentPresenter presenter;
    private CardView cvMakanan;
    private CardView cvMinuman;
    private CardView cvSnack;
    private CardView cvDaftarpesanan;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        initUi(view);
        initEvent();

        return view;
    }

    private void initUi(View view) {
        presenter = new MenuFragmentPresenter(this);
        cvMakanan = view.findViewById(R.id.cv_makanan);
        cvMinuman = view.findViewById(R.id.cv_minuman);
        cvSnack = view.findViewById(R.id.cv_snack);
        cvDaftarpesanan = view.findViewById(R.id.cv_daftarPesanan);

    }

    private void initEvent() {
        initButton();
    }

    private void initButton() {
        cvMakanan.setOnClickListener(this);
        cvMinuman.setOnClickListener(this);
        cvSnack.setOnClickListener(this);
        cvDaftarpesanan.setOnClickListener(this);
    }

    @Override
    public void daftarMakanan() {
        PindahActivity.pindahActivity(getActivity(), DaftarMenuActivity.class);
    }

    @Override
    public void daftarMinuman() {
        Toast.makeText(getActivity(), "Minuman", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void daftarSnack() {
        Toast.makeText(getActivity(), "Snack", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void daftarPesanan() {
        Toast.makeText(getActivity(), "Pesanan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cv_makanan:
                presenter.tombolMakanan();
                break;

            case R.id.cv_minuman:
                presenter.tombolMinuman();
                break;

            case R.id.cv_snack:
                presenter.tombolSnack();
                break;

            case R.id.cv_daftarPesanan:
                presenter.tombolDaftarPesanan();
                break;
        }
    }
}
