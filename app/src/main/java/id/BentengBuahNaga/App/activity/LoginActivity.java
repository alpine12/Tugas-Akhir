package id.BentengBuahNaga.App.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pixplicity.easyprefs.library.Prefs;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.LoginContract;
import id.BentengBuahNaga.App.activity.presenter.LoginPresenter;
import id.BentengBuahNaga.App.aplication.App;
import id.BentengBuahNaga.App.helper.SharedPreff;
import id.BentengBuahNaga.App.utils.PindahActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private static final String TAG = "LoginActivity";
    private Context mContext;
    private LoginPresenter presenter;
    private EditText username;
    private App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;
        initView();
        initEvent();
    }

    private void initView() {
        presenter = new LoginPresenter(this);
        username = findViewById(R.id.username);

    }

    private void initEvent() {
        presenter.cekUsernameAda();

    }

    public void masuk(View view) {
        String user = username.getText().toString();
        presenter.cekLogin(user);

    }

    public void mendaftar(View view) {
        presenter.tombolDaftar();
    }

    @Override
    public void loginBerhasil(String message) {
        PindahActivity.pindahActivity(mContext, BerandaActivity.class);
        finish();
    }

    @Override
    public void usernameSalah(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginGagal(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void MasukHalamanDaftar() {
        PindahActivity.pindahActivity(mContext, RegisterActivity.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.getInstance().setCurrentactivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.getInstance().setCurrentactivity(null);
    }


}
