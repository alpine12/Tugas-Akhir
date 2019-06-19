package id.BentengBuahNaga.App.helper;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.zxing.Result;
import com.pixplicity.easyprefs.library.Prefs;

import id.BentengBuahNaga.App.R;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private static final String TAG = "Scanner";
    private ZXingScannerView mScannerView;
    private Toolbar toolbar;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Scan Result");
        dialog.setMessage(rawResult.getText());
        dialog.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                mScannerView.setResultHandler(Scanner.this); // Register ourselves as a handler for scan results.
//                mScannerView.startCamera();          // Start camera on resume
//                mScannerView.resumeCameraPreview(Scanner.this);
                Prefs.putString(SharedPreff.getMeja(), rawResult.getText());
                finish();
            }
        });
        AlertDialog show = dialog.create();
        show.show();

        if (show.isShowing()){
            mScannerView.stopCamera();

        }



        // If you would like to resume scanning, call this method below:
        //mScannerView.resumeCameraPreview(this);
    }
}
