package com.dodge.game.AssetsPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;



/**
 * Created by Irfan Sharif on 5/18/2015.
 */
public class Target {
    public Sprite image;
    public Rectangle bounds;
    public Rectangle boundsBlur;
    public Sprite imageBlur;

    public Target() {
        image = Assets.target;
        imageBlur = Assets.targetBlur;
        bounds = new Rectangle(Gdx.graphics.getWidth()/2 - image.getWidth()/2,Gdx.graphics.getHeight()/2 - image.getHeight()/2,32,32);
        boundsBlur = new Rectangle(Gdx.graphics.getWidth()/2 - imageBlur.getWidth()/2,Gdx.graphics.getHeight()/2 - imageBlur.getHeight()/2,64,64);
    }
}
