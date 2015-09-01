package screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * Abstract superclass of screen-type objects (sometimes called views.)
 * They represent the different views that the game has, such as start screen,
 * game screen and end screen.
 *
 */
public abstract class Screen {

    public abstract void create();

    public abstract void update();

    public abstract void render(SpriteBatch sb);

    public abstract void resize(int width, int height);

    public abstract void dispose();

    public abstract void pause();

    public abstract void resume();


}
