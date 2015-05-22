package com.dodge.game;

import com.badlogic.gdx.Game;
import com.dodge.game.Screens.WelcomeScreen;
import com.dodge.game.AssetsPackage.Assets;

public class GameClass extends Game {

	public com.dodge.game.Screens.GameScreen gameScreen;
	public com.dodge.game.Screens.WelcomeScreen welcomeScreen;
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
		gameScreen = new com.dodge.game.Screens.GameScreen(this);
		setScreen(gameScreen);
	}

	public void setWelcomeScreen() {
		welcomeScreen = new WelcomeScreen(this);
		setScreen(welcomeScreen);
	}
}
