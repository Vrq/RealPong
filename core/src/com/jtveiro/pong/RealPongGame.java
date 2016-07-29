package com.jtveiro.pong;

import com.badlogic.gdx.Game;
import com.jtveiro.pong.screens.GameplayScreen;
import com.jtveiro.pong.screens.MainScreen;
import com.jtveiro.pong.screens.OptionsScreen;
import com.jtveiro.pong.screens.ScoreboardScreen;
import com.jtveiro.pong.screens.WinnerScreen;

public class RealPongGame extends Game {

	@Override
	public void create () {
		showMenu();
	}

	public void startGame() {
		setScreen(new GameplayScreen(this));
	}

	public void showScoreboard() {
		setScreen(new ScoreboardScreen(this));
	}

	public void showOptions() {
		setScreen(new OptionsScreen(this));
	}

	public void showMenu() {
		setScreen(new MainScreen(this));
	}


}
