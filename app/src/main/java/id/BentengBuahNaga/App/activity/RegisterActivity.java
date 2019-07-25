package id.BentengBuahNaga.App.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
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
    private Calendar cal;
    private int day;
    private int month;
    private int year;

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

        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        namaPengguna = findViewById(R.id.et_namaPengguna);
        namalengkap = findViewById(R.id.et_namaLengkap);
        tanggalLahir = findViewById(R.id.et_tanggalLahir);
        hp = findViewById(R.id.et_noHp);
        pekerjaan = findViewById(R.id.et_pekerjaan);
        alamat = findViewById(R.id.et_alamat);
    }

    private void initEvent() {
        tanggalLahir.setInputType(InputType.TYPE_NULL);
        tanggalLahir.requestFocus();
        tanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                    {
                        tanggalLahir.setText(year+"-"+(++monthOfYear)+"-"+dayOfMonth);
                    }};

                DatePickerDialog dpDialog=new DatePickerDialog(mContext, listener, year, month, day);
                dpDialog.show();
            }
        });

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


        if (TextUtils.isEmpty(nmPengguna) || TextUtils.isEmpty(nmLengkap) || TextUtils.isEmpty(tglLahir) || TextUtils.isEmpty(noHp)
                || TextUtils.isEmpty(job) || TextUtils.isEmpty(alamatlengkap)) {
            Toast.makeText(mContext, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        } else {
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
}
