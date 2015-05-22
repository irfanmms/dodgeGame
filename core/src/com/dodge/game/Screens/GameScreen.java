package com.dodge.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.dodge.game.UserAccessor;
import com.dodge.game.GameClass;
import com.dodge.game.AssetsPackage.*;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Quint;

/**
 * Created by Irfan Sharif on 5/17/2015.
 */
public class GameScreen implements Screen, GestureDetector.GestureListener{
    private GameClass gameClass;
    OrthographicCamera orthographicCamera;
    SpriteBatch spriteBatch;

    private TweenManager tweenManager;

    User user;
    Enemy enemy;
    Grid grid;

    public GameScreen(GameClass gameClass) {
        this.gameClass = gameClass;
        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        user = new User();
        enemy = new Enemy();
        grid = new Grid();
        spriteBatch = new SpriteBatch();

        Gdx.input.setInputProcessor(new GestureDetector(this));
        Gdx.graphics.setContinuousRendering(true);

        tweenManager = new TweenManager();
        Tween.registerAccessor(Sprite.class, new UserAccessor());
        Tween.set(user.image, UserAccessor.POSITIONXY).target(Gdx.graphics.getWidth()/2 - 16,Gdx.graphics.getHeight()/2 - 16).start(tweenManager);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(2.37F, 0.27F, 0.36F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        orthographicCamera.update();

        tweenManager.update(delta * 10);
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        spriteBatch.begin();
            spriteBatch.draw(grid.image, grid.bounds.x, grid.bounds.y);
            user.image.draw(spriteBatch);
        spriteBatch.end();

        if(user.bounds.overlaps(enemy.bounds)) gameClass.actionResolver.showToast("Overlap!");

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        if(Math.abs(velocityX) > Math.abs(velocityY)) {
            if(velocityX > 0) {
                if(!tooFar(user.bounds.x + (grid.bounds.getWidth()/3 - 10), user.bounds.y))
                    user.bounds.x += (grid.bounds.getWidth() / 3 - 10);
            } else {
                if(!tooFar(user.bounds.x - (grid.bounds.getWidth()/3 - 10), user.bounds.y))
                    user.bounds.x -= (grid.bounds.getWidth() / 3 - 10);
            }
        } else {
            if(velocityY > 0) {
                if(!tooFar(user.bounds.x, user.bounds.y - (grid.bounds.getWidth()/3 - 10)))
                    user.bounds.y -= (grid.bounds.getWidth()/3 - 10);
            } else {
                if(!tooFar(user.bounds.x, user.bounds.y + (grid.bounds.getWidth()/3 - 10)))
                    user.bounds.y += (grid.bounds.getWidth()/3 - 10);
            }
        }

        Tween.to(user.image, UserAccessor.POSITIONXY, 1f).target(user.bounds.x, user.bounds.y).ease(Quint.OUT).start(tweenManager);
        return true;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    public boolean tooFar(float xCoord, float yCoord) {
        float deltaX = Math.abs(xCoord - Gdx.graphics.getWidth()/2);
        float deltaY = Math.abs(yCoord - Gdx.graphics.getHeight() / 2);

        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        if(distance > grid.bounds.getWidth()/2) {
            return true;
        }
        else return false;
    }
}
