package entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.logoteknia.spaceinvadersjava.SpaceInvaders;
import com.logoteknia.spaceinvadersjava.TextureManager;

/**
 * This is the class Enemy, that is instantiated to produce enemies to the game
 *
 */
public class Enemy extends Entity {

    /**
     * Constructor, uses the TextureManager's ENEMY texture
     * @param position The position where the enemy is created
     * @param direction The direction vector where the Enemy moves
     */
    public Enemy(Vector2 position, Vector2 direction) {
        super(TextureManager.ENEMY, position, direction);
    }
    /**
     * Alternative constructor, to be used if Enemy is extended further to create different enemies.
     * @param texture The texture to be used when creating the enemy
     * @param position The position where the enemy is created
     * @param direction The direction vector where the Enemy moves
     */
    public Enemy(Texture texture, Vector2 position, Vector2 direction) {
        super(texture, position, direction);
    }

    /**
     * Update the position of Enemy. If goes below screen, move back up.
     */
    @Override
    public void update() {
        position.add(direction);

        if (position.y <= -TextureManager.ENEMY.getHeight()) {
            float x = MathUtils.random(0, SpaceInvaders.WIDTH - TextureManager.ENEMY.getWidth());
            position.set(x, SpaceInvaders.HEIGHT);
        }
    }

}
