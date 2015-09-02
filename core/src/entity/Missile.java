package entity;

import com.badlogic.gdx.math.Vector2;
import com.logoteknia.spaceinvadersjava.SpaceInvaders;
import com.logoteknia.spaceinvadersjava.TextureManager;

/**
 * A Missile type of object shot by the Player
 *
 */
public class Missile extends Entity {

    /**
     * Creates a new missile object to
     * @param position the position given as a parameter.
     */
    public Missile(Vector2 position) {
        super(TextureManager.MISSILE, position, new Vector2(0, 7));
    }
    /**
     * Updates the position of the missile.
     */
    @Override
    public void update() {
        position.add(direction);
    }
    /**
     * Checks if the missile has flown outside of the screen
     */
    public boolean checkEnd() {
        return position.y >= SpaceInvaders.HEIGHT;
    }

}
