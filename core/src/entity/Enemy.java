package entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.logoteknia.spaceinvadersjava.SpaceInvaders;
import com.logoteknia.spaceinvadersjava.TextureManager;

/**
 * Created by DreddTop on 16/08/15.
 */
public class Enemy extends Entity {


    public Enemy(Vector2 position, Vector2 direction) {
        super(TextureManager.ENEMY, position, direction);
    }

    public Enemy(Texture texture, Vector2 position, Vector2 direction) {
        super(texture, position, direction);
    }

    @Override
    public void update() {
        position.add(direction);

        if (position.y <= -TextureManager.ENEMY.getHeight()) {
            float x = MathUtils.random(0, SpaceInvaders.WIDTH - TextureManager.ENEMY.getWidth());
            position.set(x, SpaceInvaders.HEIGHT);
        }


    }
}
