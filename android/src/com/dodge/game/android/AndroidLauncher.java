package com.dodge.game.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.dodge.game.GameClass;

public class AndroidLauncher extends AndroidApplication{

	ActionResolverAndroid actionResolverAndroid;


	@Override
	protected void onCreate (Bundle savedInstanceState) {
		hideSystemUi();
		super.onCreate(savedInstanceState);
		actionResolverAndroid = new ActionResolverAndroid(this);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.hideStatusBar=true;
		config.useImmersiveMode=true;
		initialize(new GameClass(actionResolverAndroid), config);
	}

	private void hideSystemUi() {
		getWindow().getDecorView().setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
						| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_FULLSCREEN
						| View.SYSTEM_UI_FLAG_IMMERSIVE);
	}
}
