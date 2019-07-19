package id.BentengBuahNaga.App.activity.fragment;


import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.pixplicity.easyprefs.library.Prefs;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.HistoryTransaksiActivity;
import id.BentengBuahNaga.App.activity.LoginActivity;
import id.BentengBuahNaga.App.activity.contract.AkunFragmenContract;
import id.BentengBuahNaga.App.activity.presenter.AkunFragmenPresenter;
import id.BentengBuahNaga.App.utils.PindahActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AkunFragment extends Fragment implements AkunFragmenContract.View, View.OnClickListener {
    private static final String TAG = "AkunFragment";
    private CardView transaksiHistor;
    private CardView detailAkun;
    private CardView keluar;
    private AkunFragmenPresenter presenter;
    private View v;
    private Context context;
    private NotificationManagerCompat notificationManager;
    private NotificationManager manager;

    public AkunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_akun, container, false);
        v=view;
        presenter= new AkunFragmenPresenter(this);
        presenter.initMain();

        return view;
    }


    @Override
    public void initUi() {
        context =getActivity();
        transaksiHistor = v.findViewById(R.id.history_transaksi);
        keluar = v.findViewById(R.id.keluar);
    }

    @Override
    public void initEvent() {
        transaksiHistor.setOnClickListener(this);
        keluar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.detail_akun:
                break;

            case R.id.history_transaksi:
                PindahActivity.pindahActivity(context, HistoryTransaksiActivity.class);
                break;
            case R.id.keluar:
                getActivity().finish();
                Prefs.clear();
                PindahActivity.pindahActivity(context,LoginActivity.class);
                break;
        }
    }
}
