package com.dodge.game.android;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.dodge.game.GameClass;

public class AndroidLauncher extends AndroidApplication{

	ActionResolverAndroid actionResolverAndroid;


	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionResolverAndroid = new ActionResolverAndroid(this);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new GameClass(actionResolverAndroid), config);
	}
}
