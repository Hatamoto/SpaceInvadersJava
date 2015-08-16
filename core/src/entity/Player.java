package entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.logoteknia.spaceinvadersjava.TextureManager;

/**
 * Created by DreddTop on 13/08/15.
 */
public class Player extends Entity {

    public Player(Vector2 position, Vector2 direction) {
        super(TextureManager.PLAYER, position, direction);
    }

    @Override
    public void update() {
        position.add(direction);

        if (Gdx.input.isKeyPressed(Input.Keys.A))
            setDirection(-300, 0);
        else if (Gdx.input.isKeyPressed(Input.Keys.D))
            setDirection(300, 0);
        else
            setDirection(0, 0);

    }
}
