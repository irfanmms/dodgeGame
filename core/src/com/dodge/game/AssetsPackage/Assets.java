package com.dodge.game.AssetsPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Irfan Sharif on 5/17/2015.
 */
public class Assets {

    public static Texture welcomeScreen;
    public static Sprite spriteBack;

    public static Texture iconTexture;
    public static Sprite icon;

    public static Texture userTexture;
    public static Sprite user;
    public static Texture userBlurTexture;
    public static Sprite userBlur;

    public static Texture enemyTexture;
    public static Sprite enemy;
    public static Texture enemyBlurTexture;
    public static Sprite enemyBlur;

    public static Texture gridTexture;
    public static Sprite grid;
    public static Texture gridBlurTexture;
    public static Sprite gridBlur;

    public static Texture targetTexture;
    public static Sprite target;
    public static Texture targetBlurTexture;
    public static Sprite targetBlur;

    public static Texture pauseButtonTexture;
    public static Sprite pauseButton;

    public static BitmapFont fontHairline;
    public static BitmapFont fontLight;

    public static float SCALE_WIDTH_RATIO;
    public static float SCALE_HEIGHT_RATIO;



    public static void load() {
        //welcomeScreen = new Texture("welcomeScreen.png");
        //SCALE_WIDTH_RATIO = (welcomeScreen.getWidth()/(float) Gdx.graphics.getWidth());
        //SCALE_HEIGHT_RATIO = (welcomeScreen.getHeight()/(float)Gdx.graphics.getHeight());
        //spriteBack = new Sprite(welcomeScreen);
        //spriteBack.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        //spriteBack.setSize(spriteBack.getWidth() / SCALE_WIDTH_RATIO, spriteBack.getHeight() / SCALE_HEIGHT_RATIO);

        iconTexture = new Texture("smallIcon.png");
        icon = new Sprite(iconTexture);

        userTexture = new Texture("user.png");
        user = new Sprite(userTexture);
        userBlurTexture = new Texture("userBlur.png");
        userBlur = new Sprite(userBlurTexture);

        enemyTexture = new Texture("enemy.png");
        enemy = new Sprite(enemyTexture);
        enemyBlurTexture = new Texture("enemyBlur.png");
        enemyBlur = new Sprite(enemyBlurTexture);

        gridTexture = new Texture("grid.png");
        grid = new Sprite(gridTexture);
        gridBlurTexture = new Texture("gridBlur.png");
        gridBlur = new Sprite(gridBlurTexture);

        targetTexture = new Texture("target.png");
        target = new Sprite(targetTexture);
        targetBlurTexture = new Texture("targetBlur.png");
        targetBlur = new Sprite(targetBlurTexture);

        pauseButtonTexture = new Texture("pauseButton.png");
        pauseButton = new Sprite(pauseButtonTexture);

        FreeTypeFontGenerator genHairline = new FreeTypeFontGenerator(Gdx.files.internal("Montserrat-Light.otf"));
        fontHairline = genHairline.generateFont(50);
        fontHairline.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        fontHairline.setColor(Color.WHITE);

        FreeTypeFontGenerator genLight = new FreeTypeFontGenerator(Gdx.files.internal("Montserrat-Regular.otf"));
        fontLight = genLight.generateFont(128);
        fontLight.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        fontLight.setColor(Color.WHITE);

    }
}
