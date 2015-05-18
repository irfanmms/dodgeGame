package com.dodge.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;

import java.awt.Rectangle;

/**
 * Created by Irfan Sharif on 5/18/2015.
 */
public class User {
    public Sprite image;
    public final Circle bounds;

    public User() {
        image = Assets.user;
        bounds = new Circle(0,0,16);
    }
}
