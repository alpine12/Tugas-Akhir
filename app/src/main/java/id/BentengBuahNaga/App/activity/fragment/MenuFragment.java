package id.BentengBuahNaga.App.activity.fragment;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.BerandaActivity;
import id.BentengBuahNaga.App.activity.DaftarMenuActivity;
import id.BentengBuahNaga.App.activity.DaftarPesananActivity;
import id.BentengBuahNaga.App.activity.contract.MenuFragmentContract;
import id.BentengBuahNaga.App.activity.presenter.MenuFragmentPresenter;
import id.BentengBuahNaga.App.helper.Scanner;
import id.BentengBuahNaga.App.helper.SharedPreff;
import id.BentengBuahNaga.App.utils.PindahActivity;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements MenuFragmentContract.View,
        View.OnClickListener, EasyPermissions.PermissionCallbacks {
    private static final String TAG = "MenuFragment";
    private MenuFragmentPresenter presenter;
    private CardView cvMakanan;
    private CardView cvMinuman;
    private CardView cvSnack;
    private CardView cvDaftarpesanan;
    private Context mContext;
    private TextView nmpelanggan;
    private TextView noMeja;
    private ImageView qrCOde;


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
        mContext = getActivity();
        presenter = new MenuFragmentPresenter(this);
        cvMakanan = view.findViewById(R.id.cv_makanan);
        cvMinuman = view.findViewById(R.id.cv_minuman);
        cvSnack = view.findViewById(R.id.cv_snack);
        cvDaftarpesanan = view.findViewById(R.id.cv_daftarPesanan);
        nmpelanggan = view.findViewById(R.id.tv_nmPelanggan);
        noMeja = view.findViewById(R.id.tv_idMeja);
        qrCOde = view.findViewById(R.id.img_scanBarcode);

    }

    private void initEvent() {
        initButton();
//        presenter.initPelanggan();
    }

    private void initButton() {
        cvMakanan.setOnClickListener(this);
        cvMinuman.setOnClickListener(this);
        cvSnack.setOnClickListener(this);
        cvDaftarpesanan.setOnClickListener(this);
        qrCOde.setOnClickListener(this);
    }



    @Override
    public void initPelanggan() {
        nmpelanggan.setText(Prefs.getString(SharedPreff.getNamaLengkap(), null));
        if (Prefs.getString(SharedPreff.getMeja(), null) == null) {
            noMeja.setText("Mohon Scan Meja");
        } else {
            noMeja.setText(Prefs.getString(SharedPreff.getMeja(), null));
        }
    }

    @Override
    public void showQRcodeScanner() {
        presenter.PermCamera();
    }

    @Override
    public void daftarMakanan() {

        if (Prefs.getString(SharedPreff.getMeja(), null) == null) {
            presenter.cekmejaKososng();
        } else {
            PindahActivity.pindahActivityParam(mContext, DaftarMenuActivity.class, "1");
        }

    }

    @Override
    public void daftarMinuman() {
        if (Prefs.getString(SharedPreff.getMeja(), null) == null) {
            presenter.cekmejaKososng();
        } else {
            PindahActivity.pindahActivityParam(mContext, DaftarMenuActivity.class, "2");
        }
    }

    @Override
    public void daftarSnack() {
        if (Prefs.getString(SharedPreff.getMeja(), null) == null) {
            presenter.cekmejaKososng();
        } else {
            PindahActivity.pindahActivityParam(mContext, DaftarMenuActivity.class, "3");
        }
    }

    @Override
    public void daftarPesanan() {
        if (Prefs.getString(SharedPreff.getMeja(), null) == null) {
            presenter.cekmejaKososng();
        } else {
            PindahActivity.pindahActivityParam(mContext, DaftarPesananActivity.class, "4");
        }
    }

    @Override
    @AfterPermissionGranted(100)
    public void PermOpenCamera() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(mContext, perms)) {
            PindahActivity.pindahActivity(mContext, Scanner.class);
        } else {
            EasyPermissions.requestPermissions(this, "Membutuhkan akses kamera",
                    100, perms);
        }
    }

    @Override
    public void pesanKodeMejaKososng() {
        Toast.makeText(mContext, "Mohon Scan Meja Dahulu", Toast.LENGTH_SHORT).show();
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

            case R.id.img_scanBarcode:
                presenter.tombolQrCode();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.initPelanggan();
    }

}
