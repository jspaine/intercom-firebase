package com.intercom2;

//import com.google.firebase.messaging.FirebaseMessagingService;
import com.dieam.reactnativepushnotification.modules.RNPushNotificationListenerService;
import io.intercom.android.sdk.push.IntercomPushClient;
import com.google.firebase.messaging.RemoteMessage;
import android.util.Log;
import java.util.Map;

public class AppMessagingService extends RNPushNotificationListenerService {
//    public class OverriddenMessagingService extends MessagingService {
    private static final String TAG = "AppMessagingService";
    private final IntercomPushClient intercomPushClient = new IntercomPushClient();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map message = remoteMessage.getData();
        if (intercomPushClient.isIntercomPush(message)) {
            Log.d(TAG, "Intercom message received");
            intercomPushClient.handlePush(getApplication(), message);
        } else {
            Log.d(TAG, "Other message received");
            super.onMessageReceived(remoteMessage);
        }
    }
//    }
}
