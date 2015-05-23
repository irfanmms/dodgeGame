package com.dodge.game.AssetsPackage;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;

/**
 * Created by Irfan Sharif on 5/18/2015.
 */
public class Enemy {
    public Sprite image;
    public Sprite Blur;
    public final Circle bounds;

    public Enemy() {
        image = Assets.enemy;
        image = Assets.enemyBlur;
        bounds = new Circle(0,0,24);
    }
}
