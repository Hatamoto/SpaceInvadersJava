package screen;

import camera.OrthoCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import entity.EntityManager;
import entity.Player;

/**
 * Why the packages can not be inside the main like com.logoteknia.spaceinvadersjava.entity etc?
 *
 * This will be the menu screen.
 *
 * Created by DreddTop on 13/08/15.
 */

public class GameScreen extends Screen {

    private OrthoCamera camera;
    private EntityManager entityManager;

    @Override
    public void create() {
        System.out.println("Created");
        camera = new OrthoCamera();
        entityManager = new EntityManager(25);
    }

    @Override
    public void update() {
        camera.update();
        entityManager.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        entityManager.render(sb);
        sb.end();
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
