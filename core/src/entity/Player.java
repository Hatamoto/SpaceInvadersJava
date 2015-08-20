package entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.logoteknia.spaceinvadersjava.TextureManager;

import javax.swing.*;

/**
 * Created by DreddTop on 13/08/15.
 */
public class Player extends Entity {

    private final EntityManager entityManager;
    private long lastFire;

    public Player(Vector2 position, Vector2 direction, EntityManager entityManager) {

        super(TextureManager.PLAYER, position, direction);
        this.entityManager = entityManager;
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

        // Here we need interfaces, passing references is the bad way!!!
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            if(System.currentTimeMillis() - lastFire >= 250) {
                entityManager.addEntity(new Missile(position.cpy().add(25, TextureManager.PLAYER.getHeight() + 10)));
                lastFire = System.currentTimeMillis(); // can this crash or bug?
            }


    }
}
