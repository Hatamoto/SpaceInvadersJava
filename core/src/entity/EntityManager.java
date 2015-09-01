package entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.logoteknia.spaceinvadersjava.SpaceInvaders;
import com.logoteknia.spaceinvadersjava.TextureManager;
import screen.GameOverScreen;
import screen.ScreenManager;

/**
 * EntityManager maintains references to all entities in the game,
 * calls for updates and collision detection for them and checks for
 * conditions of game over.
 */
public class EntityManager {

    private final Array<Entity> entities = new Array<Entity>();
    private final Player player;
    /**
     * Create a new EntityManager with some enemies.
     * @param amount a given number of enemies.
     *
     */
    public EntityManager(int amount) {
        player = new Player(new Vector2(240, 18), new Vector2(0, 0), this);
        for (int i = 0; i < amount; i++) {
            float x = MathUtils.random(0, SpaceInvaders.WIDTH - TextureManager.ENEMY.getWidth());
            float y = MathUtils.random(SpaceInvaders.HEIGHT, SpaceInvaders.HEIGHT * 2);
            addEntity(new Enemy(new Vector2(x,y), new Vector2(0, -2)));
        }
    }
    /**
     * Update all entities, remove those missiles that have gone out of bounds
     *
     */
    public void update() {
        for (Entity e : entities)
            e.update();
        for (Missile m : getMissiles())
            if (m.checkEnd())
                entities.removeValue(m, false);
        player.update();
        checkCollisions();
    }

    /**
     * Render all the entities on screen
     * @param sb the sprite batch
     */

    public void render(SpriteBatch sb) {
        for (Entity e : entities)
            e.render(sb);
        player.render(sb);
    }

    /**
     * Checks for collisions between game objects,
     * also checks for victory/defeat conditions and
     * if they are fulfilled goes to the appropriate end screen.
     */
    private void checkCollisions() {
        for (Enemy e : getEnemies()) {
            for (Missile m : getMissiles()) {
                if (e.getBounds().overlaps(m.getBounds())) {
                    entities.removeValue(e, false);
                    entities.removeValue(m, false);
                    if (gameOver()) {
                        ScreenManager.setScreen(new GameOverScreen(true));
                    }
                }
            }
            if (e.getBounds().overlaps(player.getBounds())) {
                ScreenManager.setScreen(new GameOverScreen(false));
            }
        }
    }

    /**
     * Adds a new entity to the array of entities.
     * @param entity Entity to add.
     */
    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    /**
     * Returns an array of all Entities in the game that are of the type Enemy
     * @return Array of Enemy type objects.
     */

    private Array<Enemy> getEnemies() {
        Array<Enemy> returnArray = new Array<Enemy>();
        for (Entity e : entities)
            if (e instanceof Enemy) {
                returnArray.add((Enemy) e);
            }
        return returnArray;
    }

    /**
     * Returns an array of all Entities in the game that are of the type Missile
     * @return Array of Missile type objects.
     */

    private Array<Missile> getMissiles() {
        Array<Missile> returnArray = new Array<Missile>();
        for (Entity e : entities)
            if (e instanceof Missile)
                returnArray.add((Missile)e);
        return returnArray;
    }

    /**
     * If no enemies are left, end the game.
     * @return Is game over?
     */
    public boolean gameOver() {
        return getEnemies().size <= 0;
    }


}
