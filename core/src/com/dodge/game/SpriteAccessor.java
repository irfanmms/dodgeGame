package com.dodge.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.TweenAccessor;

/**
 * Created by Irfan Sharif on 5/24/2015.
 */
public class SpriteAccessor implements TweenAccessor<Sprite> {
    public static final int ROTATION = 0;
    public static final int POSITIONY = 1;
    public static final int POSITIONX = 2;
    public static final int POSITIONXY = 3;
    public static final int ALPHA = 4;

    @Override
    public int getValues(Sprite target, int tweenType, float[] returnValues) {
        switch (tweenType){
            case ROTATION:
                returnValues[0] = target.getRotation();
                return 1;
            case POSITIONX:
                returnValues[0] = target.getX();
                return 1;
            case POSITIONY:
                returnValues[0] = target.getY();
                return 1;
            case POSITIONXY:
                returnValues[0] = target.getX();
                returnValues[1] = target.getY();
                return 2;
            case ALPHA:
                returnValues[0] = target.getColor().a;
                return 1;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public void setValues(Sprite target, int tweenType, float[] newValues) {
        switch (tweenType){
            case ROTATION:
                target.setRotation(newValues[0]);
                break;
            case POSITIONX:
                target.setX(newValues[0]);
                break;
            case POSITIONY:
                target.setY(newValues[0]);
                break;
            case POSITIONXY:
                target.setX(newValues[0]);
                target.setY(newValues[1]);
                break;
            case ALPHA:
                target.setColor(target.getColor().r,target.getColor().g,target.getColor().b,newValues[0]);
            default:
                assert false;
        }
    }
}
