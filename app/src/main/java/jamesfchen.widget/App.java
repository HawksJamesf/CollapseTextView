package com.hawksjamesf.collapsetextview;

import android.app.Application;

import androidx.annotation.Nullable;
import androidx.core.provider.FontRequest;
import androidx.emoji.bundled.BundledEmojiCompatConfig;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.text.FontRequestEmojiCompatConfig;

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Oct/16/2018  Tue
 */
public class App extends Application {
    public static final boolean USER_BUNDLED = true;

    @Override
    public void onCreate() {
        super.onCreate();
//        EmojiManager.install(new IosEmojiProvider());

        EmojiCompat.Config config;
        if (USER_BUNDLED) {

            config = new BundledEmojiCompatConfig(getApplicationContext());
        } else {
//            FontRequest fontRequest=new FontRequest();
            FontRequest fontRequest = new FontRequest(
                    "com.google.android.gms.fonts",
                    "com.google.android.gms",
                    "Noto Color Emoji Compat",
                    R.array.com_google_android_gms_fonts_certs);
            config = new FontRequestEmojiCompatConfig(getApplicationContext(), fontRequest);

        }
        config.setReplaceAll(true)
                .registerInitCallback(new EmojiCompat.InitCallback() {
                    @Override
                    public void onInitialized() {
                        super.onInitialized();
                    }

                    @Override
                    public void onFailed(@Nullable Throwable throwable) {
                        super.onFailed(throwable);
                    }
                });

        EmojiCompat.init(config);
    }
}
