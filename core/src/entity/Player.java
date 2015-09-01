package entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.logoteknia.spaceinvadersjava.TextureManager;

import javax.swing.*;

/**
 * Player is a class that is instanced to become the player's spaceship
 *
 */
public class Player extends Entity {

    private final EntityManager entityManager;
    private long lastFire;

    /**
     * Create a new Player object.
     * @param position The position where the Player will be on screen
     * @param direction The direction where the Player will be moving
     * @param entityManager The EntityManager that the Player will be attached to.
     */
    public Player(Vector2 position, Vector2 direction, EntityManager entityManager) {

        super(TextureManager.PLAYER, position, direction);
        this.entityManager = entityManager;
    }

    /**
     * Updates the Player object, changes position based on direction,
     * and direction based on whether a key is pressed or not, and shoots
     * a new Missile object if enough time has passed before the last shot.
     */
    @Override
    public void update() {
        position.add(direction);

        if (Gdx.input.isKeyPressed(Input.Keys.A))
            setDirection(-300, 0);
        else if (Gdx.input.isKeyPressed(Input.Keys.D))
            setDirection(300, 0);
        else
            setDirection(0, 0);

        // Here we need interfaces, passing references is the bad way!!!
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            if(System.currentTimeMillis() - lastFire >= 250) {
                entityManager.addEntity(new Missile(position.cpy().add(25, TextureManager.PLAYER.getHeight() + 10)));
                lastFire = System.currentTimeMillis(); // can this crash or bug?
            }


    }
}
