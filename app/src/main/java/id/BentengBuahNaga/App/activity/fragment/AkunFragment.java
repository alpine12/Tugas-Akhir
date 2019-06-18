package id.BentengBuahNaga.App.activity.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import id.BentengBuahNaga.App.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AkunFragment extends Fragment {


    public AkunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_akun, container, false);
        return view;
    }

}
