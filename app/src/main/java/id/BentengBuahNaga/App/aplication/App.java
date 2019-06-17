package id.BentengBuahNaga.App.aplication;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static App mInstance = null;

    public Context currentactivity = null;


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
