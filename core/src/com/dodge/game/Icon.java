package com.dodge.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Irfan Sharif on 5/21/2015.
 */
public class Icon {
    public Sprite image;
    public Rectangle bounds;

    public Icon() {
        image = Assets.icon;
        bounds = new Rectangle(Gdx.graphics.getWidth()/2 - 100,Gdx.graphics.getHeight()/2 - 100,200,200);
    }
}
