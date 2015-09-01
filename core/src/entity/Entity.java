package entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * The superclass of all objects in the game, provides functionality that is common to all
 * game objects. This is an abstract class.
 */
public abstract class Entity {

    protected Texture texture;
    protected Vector2 position, direction;

    /**
     * Constructs a new Entity, not called directly, only through subclasses constructors.
     *
     * @param texture Texture that will be used
     * @param position The position where the entity will be initially
     * @param direction The direction vector that determines the speed and directionof the object's movement
     */
    public Entity(Texture texture, Vector2 position, Vector2 direction) {
        this.texture = texture;
        this.position = position;
        this.direction = direction;

    }

    public abstract void update();

    /**
     * Render the sprites that have been batched
     * @param sb The sprite batch
     */
    public void render(SpriteBatch sb) {
        sb.draw(texture, position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    /**
     * Returns the 'bounding box' of the entity for collision detection
     * @return bounding box
     */
    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    /**
     * Set the direction of the object, relative to the delta time.
     */
    public void setDirection(float x, float y) {
        direction.set(x, y);
        direction.scl(Gdx.graphics.getDeltaTime());
    }
}
