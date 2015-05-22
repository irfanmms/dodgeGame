package com.dodge.game.android;

import android.content.Context;
import android.widget.Toast;

import com.dodge.game.ActionResolver;

/**
 * Created by Irfan Sharif on 5/17/2015.
 */
public class ActionResolverAndroid implements ActionResolver {
    android.os.Handler handler;
    Context context;

    public ActionResolverAndroid(Context context) {
        handler = new android.os.Handler();
        this.context = context;
    }

    public void showToast(final CharSequence text) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
