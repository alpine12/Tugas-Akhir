package id.BentengBuahNaga.App.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.HashMap;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.DetailAkunContract;
import id.BentengBuahNaga.App.activity.model.DetailAkunModel;
import id.BentengBuahNaga.App.activity.presenter.DetailAkunPresenter;
import id.BentengBuahNaga.App.helper.SharedPreff;

public class DetailAkunActivity extends AppCompatActivity implements DetailAkunContract.View {
    private static final String TAG = "DetailAkunActivity";
    private DetailAkunPresenter p;
    private ImageButton back;
    private TextView titleToolbar;
    private EditText namaPengguna;
    private EditText namaLengkap;
    private EditText tgglLahir;
    private EditText Nohp;
    private EditText pekerjaan;
    private EditText alamat;
    private Button update;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_akun);
        p = new DetailAkunPresenter(this);
        p.initMain();
    }

    @Override
    public void initView() {
        context = this;
        back = findViewById(R.id.backArrow);
        titleToolbar = findViewById(R.id.title_toolbar);
        namaPengguna = findViewById(R.id.et_namaPengguna);
        namaLengkap = findViewById(R.id.et_namaLengkap);
        tgglLahir = findViewById(R.id.et_tanggalLahir);
        Nohp = findViewById(R.id.et_noHp);
        pekerjaan = findViewById(R.id.et_pekerjaan);
        alamat = findViewById(R.id.et_alamat);
        update = findViewById(R.id.btn_update);
    }

    @Override
    public void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        titleToolbar.setText("Pengaturan Akun");
        namaPengguna.setText(Prefs.getString(SharedPreff.getNamaPengguna(), null));
        namaLengkap.setText(Prefs.getString(SharedPreff.getNamaLengkap(), null));
        tgglLahir.setText(Prefs.getString(SharedPreff.getTanggalLahir(), null));
        Nohp.setText(Prefs.getString(SharedPreff.getNoHp(), null));
        pekerjaan.setText(Prefs.getString(SharedPreff.getPekerjaan(), null));
        alamat.setText(Prefs.getString(SharedPreff.getAlamat(), null));
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap map = new HashMap();
                map.put("a", namaLengkap.getText().toString());
                map.put("b", tgglLahir.getText().toString());
                map.put("c", Nohp.getText().toString());
                map.put("d", pekerjaan.getText().toString());
                map.put("e", alamat.getText().toString());

                p.updatePengguna(map);
            }
        });
    }

    @Override
    public void tampilpesan(String pesan) {

        Toast.makeText(context, pesan, Toast.LENGTH_SHORT).show();
    }
}
