package id.BentengBuahNaga.App.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.LoginContract;
import id.BentengBuahNaga.App.activity.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private static final String TAG = "LoginActivity";
    private LoginPresenter presenter;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initButton();

    }

    private void initView() {
        login = findViewById(R.id.login);
        presenter = new LoginPresenter(this);

    }

    private void initButton() {

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.cekLogin();
            }
        });
    }

    @Override
    public void loginBerhasil() {

        Toast.makeText(this, "Login Succes", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginGagal() {

        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();

    }
}
