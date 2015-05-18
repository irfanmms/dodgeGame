package com.dodge.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import sun.rmi.runtime.Log;

/**
 * Created by Irfan Sharif on 5/17/2015.
 */
public class GameScreen implements Screen, GestureDetector.GestureListener{
    private GameClass gameClass;
    OrthographicCamera orthographicCamera;
    SpriteBatch spriteBatch;

    float userX, userY;

    User user;
    Enemy enemy;


    public GameScreen(GameClass gameClass) {
        this.gameClass = gameClass;
        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        user = new User();
        enemy = new Enemy();
        spriteBatch = new SpriteBatch();
        userX = ((Gdx.graphics.getWidth() / 2) - (Assets.user.getWidth() / 2));
        userY = ((Gdx.graphics.getHeight() / 2) - (Assets.user.getHeight()/2));

        Gdx.input.setInputProcessor(new GestureDetector(this));
        Gdx.graphics.setContinuousRendering(false);
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(2.37F, 0.27F, 0.36F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //orthographicCamera.update();

        //spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        spriteBatch.begin();
            //spriteBatch.draw(Assets.welcomeScreen, 0, 0);
            spriteBatch.draw(user.image,user.bounds.x,user.bounds.y);
            spriteBatch.draw(enemy.image, enemy.bounds.x, enemy.bounds.y);
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
                user.bounds.x += 50;
            } else {
                user.bounds.x -= 50;
            }
        } else {
            if(velocityY > 0) {
                user.bounds.y -= 50;
            } else {
                user.bounds.y += 50;
            }
        }
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
}
