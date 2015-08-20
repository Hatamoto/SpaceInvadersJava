package entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.logoteknia.spaceinvadersjava.SpaceInvaders;
import com.logoteknia.spaceinvadersjava.TextureManager;

/**
 * Created by DreddTop on 16/08/15.
 */
public class EntityManager {

    private final Array<Entity> entities = new Array<Entity>();
    private final Player player;

    public EntityManager(int amount) {
        player = new Player(new Vector2(240, 18), new Vector2(0, 0), this);
        for (int i = 0; i < amount; i++) {
            float x = MathUtils.random(0, SpaceInvaders.WIDTH - TextureManager.ENEMY.getWidth());
            float y = MathUtils.random(SpaceInvaders.HEIGHT, SpaceInvaders.HEIGHT * 2);
            addEntity(new Enemy(new Vector2(x,y), new Vector2(0, -2)));
        }
    }

    public void update() {
        for (Entity e : entities)
            e.update();
        for (Missile m : getMissiles())
            if (m.checkEnd())
                entities.removeValue(m, false);
        player.update();
        checkCollisions();
    }

    public void render(SpriteBatch sb) {
        for (Entity e : entities)
            e.render(sb);
        player.render(sb);
    }

    private void checkCollisions() {
        for (Enemy e : getEnemies()) {
            for (Missile m : getMissiles()) {
                if (e.getBounds().contains(m.getBounds()))
                    entities.removeValue(e, false);
                    //entities.removeValue(m, false);
            }
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    private Array<Enemy> getEnemies() {
        Array<Enemy> returnArray = new Array<Enemy>();
        for (Entity e : entities)
            if (e instanceof Enemy)
                returnArray.add((Enemy)e);
        return returnArray;
    }

    private Array<Missile> getMissiles() {
        Array<Missile> returnArray = new Array<Missile>();
        for (Entity e : entities)
            if (e instanceof Missile)
                returnArray.add((Missile)e);
        return returnArray;
    }

    public boolean gameOver() {
        return getEnemies().size <= 0;
    }


}
