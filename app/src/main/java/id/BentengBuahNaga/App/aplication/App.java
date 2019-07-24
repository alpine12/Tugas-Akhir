package id.BentengBuahNaga.App.aplication;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import com.pixplicity.easyprefs.library.Prefs;

import id.BentengBuahNaga.App.R;

public class App extends Application {

    private static App mInstance = null;
    public Context currentactivity = null;
    public static final String CHANEL_PROMOSI = "PROMOSI";
    public static final String CHANEL_PESANAN = "PESANAN";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChanel();

        buildSharedPreff();


    }

    private void createNotificationChanel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(CHANEL_PROMOSI,"PROMOSI",
                    NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("Promosi dan Event");
            channel1.enableLights(true);
            channel1.setShowBadge(true);

            NotificationChannel channel2 = new NotificationChannel(CHANEL_PESANAN,"PESANAN",
                    NotificationManager.IMPORTANCE_HIGH);
            channel2.setDescription("INFORMASI PESANAN dan PEMBAYARAN");
            channel2.enableLights(true);
            channel2.setShowBadge(true);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }

    private void buildSharedPreff(){
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }

    public void setCurrentactivity(Context currentactivity) {
        this.currentactivity = currentactivity;
    }

    public Context getCurrentactivity() {
        return currentactivity;
    }

    public static App getInstance() {
        if (mInstance == null) {
            mInstance = new App();
        }
        return mInstance;
    }


}
