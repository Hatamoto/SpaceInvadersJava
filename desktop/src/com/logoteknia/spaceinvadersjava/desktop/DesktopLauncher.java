package com.logoteknia.spaceinvadersjava.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.logoteknia.spaceinvadersjava.SpaceInvaders;

/**
 *
 * Run this to get the game to start on desktop.
 *
 * Created by DreddTop on 13/08/15.
 */

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SpaceInvaders(), config);

		config.width = SpaceInvaders.WIDTH;
		config.height = SpaceInvaders.HEIGHT;
	}
}
