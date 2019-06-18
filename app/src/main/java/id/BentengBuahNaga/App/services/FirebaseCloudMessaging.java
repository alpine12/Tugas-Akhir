package id.BentengBuahNaga.App.services;

import android.content.Context;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import id.BentengBuahNaga.App.activity.LoginActivity;
import id.BentengBuahNaga.App.activity.presenter.LoginPresenter;
import id.BentengBuahNaga.App.aplication.App;

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

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.

            } else {
                // Handle message within 10 seconds

            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

            if (App.getInstance().getCurrentactivity() != null && App.getInstance().getCurrentactivity() instanceof
                    LoginActivity) {
                ((LoginActivity) App.getInstance().getCurrentactivity()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        ((LoginActivity) App.getInstance().getCurrentactivity()).Toas("mesage");
                    }
                });
            }
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
}
