package screen;

import camera.OrthoCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import entity.EntityManager;

/**
 * This is the GameScreen class, displayed when the game is
 * being played.
 *
 */

public class GameScreen extends Screen {

    private OrthoCamera camera;
    private EntityManager entityManager;

    /**
     * Creates a new GameScreen, with a OrthoCamera object to resize
     * the game according to screen size, and a EntityManager with a
     * number of enemies, at the moment 25.
     */
    @Override
    public void create() {
        camera = new OrthoCamera();
        entityManager = new EntityManager(25);
    }
    /**
     * Updates the camera, and calls the update of the EntityManager to update all
     * entities.
     */
    @Override
    public void update() {
        camera.update();
        entityManager.update();
    }

    /**
     * Renders the screen with all the entities.
     */
    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        entityManager.render(sb);
        sb.end();
    }

    /**
     * Resize the screen (the camera).
     */
    @Override
    public void resize(int width, int height) {
        camera.resize();
    }


    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
