package screen;

import camera.OrthoCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * This will be the menu screen.
 *
 * Created by DreddTop on 13/08/15.
 */

public class MenuScreen extends Screen {

    private OrthoCamera camera;

    @Override
    public void create() {
        System.out.println("Created");
        camera = new OrthoCamera();
    }

    @Override
    public void update() {
        camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
    }

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
