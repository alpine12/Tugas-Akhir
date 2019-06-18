package id.BentengBuahNaga.App.aplication;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

import com.pixplicity.easyprefs.library.Prefs;

public class App extends Application {

    private static App mInstance = null;
    public Context currentactivity = null;

    @Override
    public void onCreate() {
        super.onCreate();

        buildSharedPreff();

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
