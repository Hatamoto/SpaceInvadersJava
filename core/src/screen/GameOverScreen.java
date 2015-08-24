package screen;

import camera.OrthoCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.logoteknia.spaceinvadersjava.SpaceInvaders;
import com.logoteknia.spaceinvadersjava.TextureManager;

/**
 * Created by DreddTop on 24/08/15.
 */
public class GameOverScreen extends Screen {

    private OrthoCamera camera;
    private Texture texture;


    public GameOverScreen(boolean won) {
        if (won)
            texture = TextureManager.GAME_WON;
        else
            texture = TextureManager.GAME_OVER;
    }

    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();

    }

    @Override
    public void update() {
        camera.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(texture, SpaceInvaders.WIDTH / 2 - texture.getWidth() / 2, SpaceInvaders.HEIGHT / 2 - texture.getHeight() /2 );
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
