package id.BentengBuahNaga.App.services;

import android.app.ActivityManager;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.BerandaActivity;
import id.BentengBuahNaga.App.activity.LoginActivity;
import id.BentengBuahNaga.App.activity.SplashScreen;
import id.BentengBuahNaga.App.activity.presenter.LoginPresenter;
import id.BentengBuahNaga.App.aplication.App;
import id.BentengBuahNaga.App.utils.PindahActivity;

public class FirebaseCloudMessaging extends FirebaseMessagingService {
    private static final String TAG = "FirebaseCloudMessaging";

    public Context currentactvity = null;
    LoginPresenter presenter;

    public Context getCurrentactvity() {
        return currentactvity;
    }

    public void setCurrentactvity(Context currentactvity) {
        this.currentactvity = currentactvity;
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {


        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            int id = Integer.valueOf(remoteMessage.getData().get("id"));
            String chanel = remoteMessage.getData().get("chanel");
            String title = remoteMessage.getData().get("title");
            String body = remoteMessage.getData().get("message");

            if (chanel.equals("PESANAN")){
                notifPesanan(id,chanel,title,body);
            }

            if (checkApp()){

            }else {

                if (chanel.equals("PROMOSI")){
                    notifPromosi(id, chanel, title, body);
                }
            }

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.

            } else {
                // Handle message within 10 seconds
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            showToast("pesan");

//            if (App.getInstance().getCurrentactivity() != null && App.getInstance().getCurrentactivity() instanceof
//                    LoginActivity) {
//                ((LoginActivity) App.getInstance().getCurrentactivity()).runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        ((LoginActivity) App.getInstance().getCurrentactivity()).Toas("mesage");
//                    }
//                });
//            }
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }


    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        //  sendRegistrationToServer(token);
    }

    public boolean checkApp(){
        ActivityManager am = (ActivityManager) this
                .getSystemService(ACTIVITY_SERVICE);

        // get the info from the currently running task
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);

        ComponentName componentInfo = taskInfo.get(0).topActivity;
        if (componentInfo.getPackageName().equalsIgnoreCase("id.BentengBuahNaga.App")) {
            return true;
        } else {
            return false;
        }
    }

    private void notifPromosi(int id, String Chanel, String title, String text) {

        Notification notification = new NotificationCompat.Builder(this, Chanel)
                .setSmallIcon(R.mipmap.ic_icon_app)
                .setContentTitle(title)
                .setContentText(text)
                .setContentInfo("info")
                .setAutoCancel(true)
                .setContentIntent(PindahActivity.pendingIntent(this, SplashScreen.class))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(id, notification);
    }

    private void notifPesanan(int id, String Chanel, String title, String text){
        Notification notification = new NotificationCompat.Builder(this, Chanel)
                .setSmallIcon(R.mipmap.ic_icon_app_round)
                .setContentTitle(title)
                .setContentText(text)
                .setAutoCancel(true)
                .setContentIntent(PindahActivity.pendingIntent(this,SplashScreen.class))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(id,notification);
    }


//    private void createNotification(String title, String Body){
//        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
////        Intent intent = new Intent(this, HomeActivity.class);
////        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
////        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, App.CHANEL_ID);
//        builder.setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle(title)
//                .setContentText(Body)
//                .setAutoCancel(true)
//                .setContentInfo("INFO")
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
////                .setContentIntent(pendingIntent)
//                .setAutoCancel(true);
//
//        Notification notif = builder.build();
//        notif.flags = Notification.FLAG_AUTO_CANCEL;
//        manager.notify(1, notif);
//    }

    private void showToast(String pesan) {
        if (App.getInstance().getCurrentactivity() != null && App.getInstance().getCurrentactivity() instanceof LoginActivity) {
            ((LoginActivity) App.getInstance().getCurrentactivity()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((LoginActivity) App.getInstance().getCurrentactivity()).Toas(pesan);
                }
            });
        }
    }
}
