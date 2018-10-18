package com.hawksjamesf.collapsetextview;

import android.app.Application;

import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.ios.IosEmojiProvider;

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Oct/16/2018  Tue
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        EmojiManager.install(new IosEmojiProvider());
    }
}
