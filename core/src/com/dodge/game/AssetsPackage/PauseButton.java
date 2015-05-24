package com.dodge.game.AssetsPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Irfan Sharif on 5/23/2015.
 */
public class PauseButton {
    public Sprite image;
    public Rectangle bounds;

    public PauseButton() {
        image = Assets.pauseButton;
        image.setSize(image.getWidth()/2f,image.getHeight()/2f);
        bounds = new Rectangle(Gdx.graphics.getWidth() - Assets.pauseButton.getWidth() * 2f,
                Gdx.graphics.getHeight() - Assets.pauseButton.getHeight() * 3f,image.getWidth(),image.getHeight());
    }
}
