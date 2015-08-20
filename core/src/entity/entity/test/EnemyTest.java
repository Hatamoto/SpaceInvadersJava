package entity.entity.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.logoteknia.spaceinvadersjava.SpaceInvaders;
import entity.Enemy;
import org.junit.Assert;
import org.junit.Test;

import static com.logoteknia.spaceinvadersjava.TextureManager.*;

/**
 * Created by DreddTop on 19/08/15.
 */
public class EnemyTest {

    @Test
    public void sample() {

        Assert.fail();
    }

    @Test
    public void testGetPosition() throws Exception {
        float x = SpaceInvaders.WIDTH / 2;
        float y = SpaceInvaders.HEIGHT * (float)1.5;

        Vector2 direction = new Vector2(0, -2);

        Enemy testEnemy = new Enemy(new Texture(Gdx.files.internal("enemy.png")), new Vector2(x,y), direction);

        Vector2 oldPosition = testEnemy.getPosition();

        testEnemy.update();

        Vector2 newPosition = testEnemy.getPosition();

        Assert.assertEquals(newPosition, oldPosition.add(direction));

    }
}
