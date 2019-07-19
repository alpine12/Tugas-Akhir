package id.BentengBuahNaga.App.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class PindahActivity {

    public static void pindahActivity(Context context, Class<?> tClass){

        Intent i = new Intent(context,tClass);
        context.startActivity(i);
    }

    public static void pindahActivityParam(Context context, Class<?> tClass, String param){

        Intent i = new Intent(context,tClass);
        i.putExtra("param", param);
        context.startActivity(i);
    }

    public static PendingIntent pendingIntent(Context context, Class<?> tClass){
        Intent i = new Intent(context,tClass);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, 0);
        return pendingIntent;
    }

    public static PendingIntent pendingIntentParam(Context context, Class<?> tClass, String param){
        Intent i = new Intent(context,tClass);
        i.putExtra("param", param);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, 0);
        return pendingIntent;
    }

}
