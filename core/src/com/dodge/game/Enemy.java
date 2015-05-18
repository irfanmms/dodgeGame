package com.dodge.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;

/**
 * Created by Irfan Sharif on 5/18/2015.
 */
public class Enemy {
    public Sprite image;
    public final Circle bounds;

    public Enemy() {
        image = Assets.enemy;
        bounds = new Circle(Gdx.graphics.getWidth()/2 - 12,Gdx.graphics.getHeight()/2 - 12,24);
    }
}
