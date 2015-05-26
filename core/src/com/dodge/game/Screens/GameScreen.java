package com.dodge.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.dodge.game.AssetsPackage.Assets;
import com.dodge.game.AssetsPackage.Enemy;
import com.dodge.game.AssetsPackage.Grid;
import com.dodge.game.AssetsPackage.PauseButton;
import com.dodge.game.AssetsPackage.Target;
import com.dodge.game.AssetsPackage.User;
import com.dodge.game.GameClass;
import com.dodge.game.SpriteAccessor;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Linear;
import aurelienribon.tweenengine.equations.Quint;

/**
 * Created by Irfan Sharif on 5/17/2015.
 */
public class GameScreen implements Screen, GestureDetector.GestureListener{
    private GameClass gameClass;
    OrthographicCamera orthographicCamera;
    SpriteBatch spriteBatch;

    private TweenManager tweenManager;
    private TweenManager tweenManagerTwo;
    Texture blurTex;
    boolean paused;
    boolean backPressed;

    private Tween targetTween;

    User user;
    Enemy enemy;
    Grid grid;
    Target target;
    PauseButton pauseButton;

    Intersector intersector;
    public GameScreen(GameClass gameClass) {

        Gdx.input.setCatchMenuKey(true);
        this.gameClass = gameClass;
        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        user = new User();
        enemy = new Enemy();
        grid = new Grid();
        target = new Target();

        intersector = new Intersector();
        pauseButton = new PauseButton();
        spriteBatch = new SpriteBatch();
        paused = false;
        backPressed = false;
        Gdx.input.setInputProcessor(new GestureDetector(this));
        Gdx.graphics.setContinuousRendering(true);

        tweenManager = new TweenManager();
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());
        Tween.set(user.image, SpriteAccessor.POSITIONXY).target(Gdx.graphics.getWidth()/2 - 16,
                Gdx.graphics.getHeight()/2 - 16).start(tweenManager);

        tweenManagerTwo = new TweenManager();
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());
        Tween.set(target.image, SpriteAccessor.POSITIONXY).target(target.bounds.x, target.bounds.y).start(tweenManagerTwo);

        target.image.setRotation(0);
        Tween.set(target.image, SpriteAccessor.ROTATION).target(target.image.getRotation());
        targetTween = Tween.to(target.image, SpriteAccessor.ROTATION, 3).target(360).repeat(Tween.INFINITY, 0).ease(Linear.INOUT);
        targetTween.start(tweenManagerTwo);
    }


    @Override
    public void show() {    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(2.37F, 0.27F, 0.36F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        orthographicCamera.update();

        tweenManager.update(delta * 10);
        tweenManagerTwo.update(delta);
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        spriteBatch.begin();

            if(paused){

                grid.imageBlur.setBounds(Gdx.graphics.getWidth() / 2 - grid.imageBlur.getWidth() / 2,
                        Gdx.graphics.getHeight() / 2 - grid.imageBlur.getWidth() / 2,
                        grid.imageBlur.getWidth(), grid.imageBlur.getHeight());
                grid.imageBlur.draw(spriteBatch);

                if(!intersector.overlaps(user.bounds, target.bounds)) {
                    target.imageBlur.setAlpha(0.9f);
                    target.imageBlur.setPosition(target.boundsBlur.x, target.boundsBlur.y);
                    target.imageBlur.setRotation(target.image.getRotation());
                    target.imageBlur.draw(spriteBatch);
                }

                user.imageBlur.setColor(1, 1, 1, .70f);
                user.imageBlur.setCenter(user.boundsBlur.x + user.imageBlur.getWidth() / 2,
                        user.boundsBlur.y + user.imageBlur.getHeight() / 2);
                user.imageBlur.draw(spriteBatch);


                Assets.fontLight.draw(spriteBatch,"Paused",Gdx.graphics.getWidth()/2,
                        4*Gdx.graphics.getHeight()/7,0, Align.center,false);


            } else {
                spriteBatch.draw(grid.image, grid.bounds.x, grid.bounds.y);
                //spriteBatch.draw(target.image, target.bounds.x, target.bounds.y);

                target.image.draw(spriteBatch);
                user.image.draw(spriteBatch);
                user.image.setPosition(user.bounds.x, user.bounds.y);
                Assets.fontHairline.draw(spriteBatch, "Best: ", 25, Gdx.graphics.getHeight() - 40);
            }

            spriteBatch.draw(pauseButton.image, pauseButton.bounds.x, pauseButton.bounds.y);

        spriteBatch.end();

        if(user.bounds.overlaps(enemy.bounds)) gameClass.actionResolver.showToast("Overlap!");

    }

    @Override
    public void resize(int width, int height) {  }

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void resume() {    }

    @Override
    public void hide() {      }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }

    public boolean tooFar(float xCoord, float yCoord) {
        float deltaX = Math.abs(xCoord - Gdx.graphics.getWidth()/2);
        float deltaY = Math.abs(yCoord + 42 - Gdx.graphics.getHeight()/2);

        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        if(distance > grid.bounds.getWidth()/2) {
            return true;
        } else return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        if( (x >= Gdx.graphics.getWidth() - 3*pauseButton.image.getWidth()) &
                (y <= 4*pauseButton.image.getHeight()) ) {
            if(!paused) {
                paused = true;
                targetTween.pause();
            } else {
                paused = false;
                targetTween.resume();
            }
        }
        return true;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        if(!paused) {
            float userOriginX = user.bounds.x + user.image.getWidth()/2;
            float userOriginY = user.bounds.y - user.image.getHeight()/2;
            if (Math.abs(velocityX) > Math.abs(velocityY)) {
                if (velocityX > 0) {
                    if (!tooFar(userOriginX + (grid.bounds.getWidth() / 3 - 10), userOriginY))
                        user.bounds.x += (grid.bounds.getWidth() / 3 - 10);
                } else {
                    if (!tooFar(userOriginX - (grid.bounds.getWidth() / 3 - 10), userOriginY))
                        user.bounds.x -= (grid.bounds.getWidth() / 3 - 10);
                }
            } else {
                if (velocityY > 0) {
                    if (!tooFar(userOriginX, userOriginY - (grid.bounds.getHeight() / 3 - 10)))
                        user.bounds.y -= (grid.bounds.getHeight() / 3 - 10);
                } else {
                    if (!tooFar(userOriginX, userOriginY + (grid.bounds.getHeight() / 3 - 10)))
                        user.bounds.y += (grid.bounds.getHeight() / 3 - 10);
                }
            }


            Tween.to(user.image, SpriteAccessor.POSITIONXY, 2f).target(user.bounds.x, user.bounds.y)
                    .ease(Quint.OUT).start(tweenManager);
            user.boundsBlur.x = (user.bounds.x - 11 );
            user.boundsBlur.y = (user.bounds.y - 11);
        }
        return true;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {   return false;   }

    @Override
    public boolean longPress(float x, float y) {    return false;   }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {    return false;   }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {    return false;   }

    @Override
    public boolean zoom(float initialDistance, float distance) {    return false;   }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1,
                         Vector2 pointer2) {    return false;   }
}
