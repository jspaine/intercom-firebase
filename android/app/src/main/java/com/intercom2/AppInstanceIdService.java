//package com.intercom2;
//
//import io.invertase.firebase.messaging.*;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import io.intercom.android.sdk.push.IntercomPushClient;
//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.iid.FirebaseInstanceIdService;
//
//public class MainInstanceIdService extends InstanceIdService {
//    private final IntercomPushClient intercomPushClient = new IntercomPushClient();
//    private static final String TAG = "AppInstanceIdService";
//
//    /**
//     * Called if InstanceID token is updated. This may occur if the security of
//     * the previous token had been compromised. This call is initiated by the
//     * InstanceID provider.
//     */
//    @Override
//    public void onTokenRefresh() {
//        // Get updated InstanceID token.
//        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//        intercomPushClient.sendTokenToIntercom(getApplication(), refreshedToken);
//        Log.d(TAG, "Refreshed token: " + refreshedToken);
//
//        // Broadcast refreshed token
//        Intent i = new Intent("io.invertase.firebase.messaging.FCMRefreshToken");
//        Bundle bundle = new Bundle();
//        bundle.putString("token", refreshedToken);
//        i.putExtras(bundle);
//        sendBroadcast(i);
//    }
//}
//public class AppInstanceIdService {
//}
