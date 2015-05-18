package com.dodge.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameClass extends Game {

	public GameScreen gameScreen;
	public WelcomeScreen welcomeScreen;
	public ActionResolver actionResolver;

	public GameClass(ActionResolver actionResolver) {
		this.actionResolver = actionResolver;
	}

	@Override
	public void create () {
		Assets.load();
		setWelcomeScreen();
	}

	public void setGameScreen() {
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);
	}

	public void setWelcomeScreen() {
		welcomeScreen = new WelcomeScreen(this);
		setScreen(welcomeScreen);
	}
}
