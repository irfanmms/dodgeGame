package com.dodge.game.AssetsPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;

/**
 * Created by Irfan Sharif on 5/18/2015.
 */
public class User {
    public Sprite image;
    public final Circle bounds;
    public final Circle boundsBlur;
    public Sprite imageBlur;

    public User() {
        image = Assets.user;
        imageBlur = Assets.userBlur;
        bounds = new Circle(Gdx.graphics.getWidth()/2 - image.getWidth()/2,Gdx.graphics.getHeight()/2 - image.getHeight()/2,16);
        boundsBlur = new Circle(Gdx.graphics.getWidth()/2 - imageBlur.getWidth()/2,Gdx.graphics.getHeight()/2 - imageBlur.getHeight()/2,16);
    }
}
