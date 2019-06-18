package id.BentengBuahNaga.App.utils;

import android.content.Context;
import android.content.Intent;

public class PindahActivity {

    public static void pindahActivity(Context context, Class<?> tClass){

        Intent i = new Intent(context,tClass);
        context.startActivity(i);
    }
}
