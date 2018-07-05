package com.intercom2;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.robinpowered.react.Intercom.IntercomPackage;

import io.intercom.android.sdk.Intercom;

import com.dieam.reactnativepushnotification.ReactNativePushNotificationPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new IntercomPackage(),
                    new ReactNativePushNotificationPackage()
            );
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        Intercom.initialize(this, "android_sdk-de9c85ce40a75f5ab47c37632d7a80180bad52d4", "vjq2zacz");
        Intercom.client().registerUnidentifiedUser();
        Intercom.client().setLauncherVisibility(Intercom.Visibility.VISIBLE);
    }
}
