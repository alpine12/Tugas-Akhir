package id.BentengBuahNaga.App.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.RegisterContract;
import id.BentengBuahNaga.App.activity.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    private static final String TAG = "RegisterActivity";
    private RegisterPresenter presenter;
    private Context mContext;
    private EditText namaPengguna;
    private EditText namalengkap;
    private EditText tanggalLahir;
    private EditText hp;
    private EditText pekerjaan;
    private EditText alamat;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mContext = this;
        initUi();
        initEvent();

    }

    private void initUi() {
        presenter = new RegisterPresenter(this);
        namaPengguna = findViewById(R.id.et_namaPengguna);
        namalengkap = findViewById(R.id.et_namaLengkap);
        tanggalLahir = findViewById(R.id.et_tanggalLahir);
        hp = findViewById(R.id.et_noHp);
        pekerjaan = findViewById(R.id.et_pekerjaan);
        alamat = findViewById(R.id.et_alamat);
    }

    private void initEvent() {

    }

    @Override
    public void berhasilmendaftar(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void gagalMendaftar(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void jaringanGagal() {

    }

    public void mendaftar(View view) {
        kirimData();
        Log.d(TAG, "mendaftar: click");
    }

    private void kirimData() {
        String token, nmPengguna, nmLengkap, tglLahir, noHp, job, alamatlengkap;
        token = "";
        nmPengguna = namaPengguna.getText().toString();
        nmLengkap = namalengkap.getText().toString();
        tglLahir = tanggalLahir.getText().toString();
        noHp = hp.getText().toString();
        job = pekerjaan.getText().toString();
        alamatlengkap = alamat.getText().toString();

        HashMap<String, String> data = new HashMap<>();
        data.put("a", token);
        data.put("b", nmPengguna);
        data.put("c", nmLengkap);
        data.put("d", tglLahir);
        data.put("e", noHp);
        data.put("f", job);
        data.put("g", alamatlengkap);

        presenter.tombolMendaftar(data);
    }


}
