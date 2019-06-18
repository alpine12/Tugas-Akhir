package id.BentengBuahNaga.App.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.helper.SharedPreff;

public class BerandaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        TextView tv =findViewById(R.id.tvtv);
        tv.setText(Prefs.getString(SharedPreff.getNamaLengkap(), null));


    }
}
