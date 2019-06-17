package id.BentengBuahNaga.App.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.LoginContract;
import id.BentengBuahNaga.App.activity.presenter.LoginPresenter;
import id.BentengBuahNaga.App.aplication.App;
import id.BentengBuahNaga.App.helper.PindahActivity;
import id.BentengBuahNaga.App.services.FirebaseCloudMessaging;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private static final String TAG = "LoginActivity";
    private Context mContext;
    private LoginPresenter presenter;
    private Button masuk;
    private Button daftar;
    private EditText username;
    private App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;
        app = new App();

        initView();
        initButton();

    }

    private void initView() {
        username = findViewById(R.id.username);
        masuk = findViewById(R.id.login);
        daftar = findViewById(R.id.daftar);
        presenter = new LoginPresenter(this);

    }

    private void initButton() {

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();

                presenter.cekLogin(user);
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.tombolDaftar();
            }
        });
    }

    public void Toas(String message){
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("wkwkw");
        dialog.show();
    }

    @Override
    public void loginBerhasil() {
        Toast.makeText(this, "Login Succes", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginGagal() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void usernameSalah() {
        Toast.makeText(this, "Username Salah", Toast.LENGTH_SHORT).show();
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
