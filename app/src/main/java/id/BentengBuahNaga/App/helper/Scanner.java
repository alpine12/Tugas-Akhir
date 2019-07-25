package id.BentengBuahNaga.App.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.zxing.Result;
import com.pixplicity.easyprefs.library.Prefs;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.ResponseModel.ResponseDeffault;
import id.BentengBuahNaga.App.network.InitRetrofit;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private static final String TAG = "Scanner";
    private ZXingScannerView mScannerView;
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    private AlertDialog.Builder dialog;
    private AlertDialog show;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        mScannerView = new ZXingScannerView(this);
        setContentView(R.layout.activity_scanner);
        toolbar = findViewById(R.id.toolbars);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SCANNER");
        ActionBar ab = getSupportActionBar();

//        ab.setDisplayHomeAsUpEnabled(true);

        frameLayout = findViewById(R.id.content_frame);
        frameLayout.addView(mScannerView);

        dialog = new AlertDialog.Builder(this);

    }


    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
//        Log.v(TAG, rawResult.getText()); // Prints scan results
//        Log.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        Log.d(TAG, "handleResult: "+ rawResult.getText());
        Log.d(TAG, "handleResult: "+ rawResult.getBarcodeFormat().toString());


        checkMeja(rawResult.getText());


        // If you would like to resume scanning, call this method below:
        //mScannerView.resumeCameraPreview(this);
    }

    private void checkMeja(String meja) {
        Call<ResponseDeffault> check = InitRetrofit.getInstance().scanMeja(meja);

        check.enqueue(new Callback<ResponseDeffault>() {
            @Override
            public void onResponse(Call<ResponseDeffault> call, Response<ResponseDeffault> response) {
                ResponseDeffault res = response.body();
                if (res.isStatus()) {

                    dialog.setMessage(meja);
                    dialog.setTitle("Scan Result");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Prefs.putString(SharedPreff.getMeja(), meja);
                            finish();
                        }
                    });

                    show = dialog.create();
                    show.show();

                    if (show.isShowing()) {
                        mScannerView.stopCamera();
                    }

                } else {
                    dialog.setMessage(res.getMessage());
                    dialog.setTitle("Scan Result");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            finish();
                        }
                    });
                    show = dialog.create();
                    show.show();

                    if (show.isShowing()) {
                        mScannerView.stopCamera();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDeffault> call, Throwable t) {
                Toast.makeText(Scanner.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
