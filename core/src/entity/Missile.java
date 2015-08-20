package entity;

import com.badlogic.gdx.math.Vector2;
import com.logoteknia.spaceinvadersjava.SpaceInvaders;
import com.logoteknia.spaceinvadersjava.TextureManager;

/**
 * Created by DreddTop on 20/08/15.
 */
public class Missile extends Entity {


    public Missile(Vector2 position) {
        super(TextureManager.MISSILE, position, new Vector2(0, 7));
    }

    @Override
    public void update() {
        position.add(direction);
    }

    public boolean checkEnd() {
        return position.y >= SpaceInvaders.HEIGHT;
    }

}
