package id.BentengBuahNaga.App.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.contract.RegisterContract;
import id.BentengBuahNaga.App.activity.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    private static final String TAG = "RegisterActivity";
    private RegisterPresenter presenter;
    private Context mContext;
    private Button mendaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mContext = this;
        initUi();
        initEvent();

    }

    private void initUi() {
        mendaftar = findViewById(R.id.mendaftar);
        presenter = new RegisterPresenter(this);
    }

    private void initEvent() {
        mendaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.tombolMendaftar();
            }
        });
    }

    @Override
    public void berhasilmendaftar() {
        Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void gagalMendaftar() {

    }
}
