package com.logoteknia.spaceinvadersjava;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screen.GameScreen;
import screen.ScreenManager;

/**
 *
 * This is the main class of the application.
 * Different platform specific "Launcher" classes are used to run the game
 * on different platforms. At the moment, Desktop is confirmed to run.
 *
 *
 */

public class SpaceInvaders extends ApplicationAdapter {

	public static int WIDTH = 480, HEIGHT = 800;
	private SpriteBatch batch;

	/**
	 * Create a new game
	 */
	@Override
	public void create () {
		batch = new SpriteBatch();
		ScreenManager.setScreen(new GameScreen());
	}

	/**
	 * Destroy the game
	 */
	@Override
	public void dispose () {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().dispose();
		batch.dispose();
	}

	/**
	 * Update and render screen
	 */
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().update();

		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().render(batch);

	}

	/**
	 * Resize the screen
	 */
	@Override
	public void resize (int width, int height) {

		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resize(width, height);

	}

	/**
	 * Pause the game
	 */
	@Override
	public void pause() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().pause();

	}

	/**
	 * Resume a paused game
	 */
	@Override
	public void resume() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resume();
	}
}
