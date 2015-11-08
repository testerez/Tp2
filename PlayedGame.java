package com.mik;

public class PlayedGame {


	public static enum Difficulty {
		unknown, easy, medium, hard
	};

	public boolean isWon;
	public int timeSpent;
	public Difficulty difficulty;
}