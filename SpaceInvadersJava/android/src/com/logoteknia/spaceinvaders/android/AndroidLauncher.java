package com.logoteknia.spaceinvaders.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.logoteknia.spaceinvaders.SpaceInvaders;

public class AndroidLauncher extends AndroidApplication {
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new SpaceInvaders(), config);
	}
}
