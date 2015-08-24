package com.logoteknia.spaceinvadersjava;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
/**
 * Created by DreddTop on 13/08/15.
 */
public class TextureManager {



    public static final Texture PLAYER = new Texture(Gdx.files.internal("player.png"));
    public static final Texture MISSILE = new Texture(Gdx.files.internal("missile.png"));
    public static final Texture ENEMY = new Texture(Gdx.files.internal("enemy.png"));
    public static final Texture GAME_OVER = new Texture(Gdx.files.internal("gameover.png"));
    public static final Texture GAME_WON = new Texture(Gdx.files.internal("gamewon.png"));

    public static Texture getENEMY() {
        return ENEMY;
    }

    public static Texture getPLAYER() {
        return PLAYER;
    }

    public static Texture getMISSILE() {
        return MISSILE;
    }
}
