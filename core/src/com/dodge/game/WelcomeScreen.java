package com.dodge.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;

import static java.lang.Thread.sleep;

/**
 * Created by Irfan Sharif on 5/18/2015.
 */
public class WelcomeScreen implements Screen, GestureDetector.GestureListener {
    private GameClass gameClass;
    OrthographicCamera orthographicCamera;
    SpriteBatch spriteBatch;
    Icon icon;

    public WelcomeScreen(final GameClass gameClass) {

        this.gameClass = gameClass;
        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        spriteBatch = new SpriteBatch();
        icon = new Icon();

        Gdx.input.setInputProcessor(new GestureDetector(this));

        float delay = 2;

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                gameClass.setGameScreen();
            }
        }, delay);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0F, 0F, 0F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        orthographicCamera.update();

        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        spriteBatch.begin();
            //spriteBatch.draw(Assets.welcomeScreen, 0, 0);
            spriteBatch.draw(icon.image, icon.bounds.x, icon.bounds.y);
        spriteBatch.end();
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
        return false;
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


        gameClass.actionResolver.showToast("pinch");

        return true;
    }
}
