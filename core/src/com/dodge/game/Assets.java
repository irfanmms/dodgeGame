package com.dodge.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.dodge.game.Assets.enemyTexture;

/**
 * Created by Irfan Sharif on 5/17/2015.
 */
public class Assets {

    public static Texture welcomeScreen;
    public static Sprite spriteBack;

    public static Texture userTexture;
    public static Sprite user;

    public static Texture enemyTexture;
    public static Sprite enemy;

    public static float SCALE_WIDTH_RATIO;
    public static float SCALE_HEIGHT_RATIO;



    public static void load() {
        welcomeScreen = new Texture("welcomeScreen.png");
        SCALE_WIDTH_RATIO = (welcomeScreen.getWidth()/(float) Gdx.graphics.getWidth());
        SCALE_HEIGHT_RATIO = (welcomeScreen.getHeight()/(float)Gdx.graphics.getHeight());
        spriteBack = new Sprite(welcomeScreen);
        spriteBack.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        spriteBack.setSize(spriteBack.getWidth() / SCALE_WIDTH_RATIO, spriteBack.getHeight() / SCALE_HEIGHT_RATIO);

        userTexture = new Texture("object.png");
        user = new Sprite(userTexture);

        enemyTexture = new Texture("enemy.png");
        enemy = new Sprite(enemyTexture);
    }
}
