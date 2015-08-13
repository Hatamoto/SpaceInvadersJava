package screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by DreddTop on 13/08/15.
 */
public abstract class Screen {

    public abstract void create();

    public abstract void render(SpriteBatch sb);

    public abstract void resize(int width, int height);

    public abstract void dispose();

    public abstract void pause();

    public abstract void resume();


}
