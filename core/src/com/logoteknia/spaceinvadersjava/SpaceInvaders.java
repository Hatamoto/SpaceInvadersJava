package com.logoteknia.spaceinvadersjava;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screen.MenuScreen;
import screen.ScreenManager;

/**
 *
 * This is the main class of the application.
 * Different platform specific "Launcher" classes are used to run the game
 * on different platforms. At the moment, Desktop is confirmed to run.
 *
 * Created by DreddTop on 13/08/15.
 */

public class SpaceInvaders extends ApplicationAdapter {

	public static int WIDTH = 480, HEIGHT = 800;
	private SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ScreenManager.setScreen(new MenuScreen());
	}

	@Override
	public void dispose () {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().dispose();
		batch.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().update();

		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().render(batch);

		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}

	@Override
	public void resize (int width, int height) {

		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resize(width, height);

	}

	@Override
	public void pause() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().pause();

	}

	@Override
	public void resume() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resume();
	}
}
