package com.dodge.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.TweenAccessor;

/**
 * Created by Irfan Sharif on 5/21/2015.
 */
public class UserAccessor implements TweenAccessor<Sprite>{

    public static final int POSITIONX = 0;
    public static final int POSITIONY = 1;
    public static final int POSITIONXY = 2;

    @Override
    public int getValues(Sprite target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case POSITIONX:
                returnValues[0] = target.getX();
                return 1;
            case POSITIONY:
                returnValues[1] = target.getY();
                return 1;
            case POSITIONXY:
                returnValues[0] = target.getX();
                returnValues[1] = target.getY();
                return 2;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public void setValues(Sprite target, int tweenType, float[] newValues) {
        switch (tweenType) {
            case POSITIONX:
                target.setX(newValues[0]);
                break;
            case POSITIONY:
                target.setX(newValues[1]);
                break;
            case POSITIONXY:
                target.setX(newValues[0]);
                target.setY(newValues[1]);
            default:
                assert false;
                break;
        }
    }
}
