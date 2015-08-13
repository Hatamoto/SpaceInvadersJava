package com.logoteknia.spaceinvadersjava;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
/**
 * Created by DreddTop on 13/08/15.
 */
public class TextureManager {

    public static Texture PLAYER = new Texture(Gdx.files.internal("player.png"));
    public static Texture MISSILE = new Texture(Gdx.files.internal("missile.png"));
    public static Texture ENEMY = new Texture(Gdx.files.internal("enemy.png"));

}
