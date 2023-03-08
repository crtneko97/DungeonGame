package com.crtneko97.demo;

public class Main{

    public static void main(String[] args) {
        Game game = new Game("");

        boolean isPlaying = true;
        Player hero = game.createHero();
        game.setStats();
        game.setLevelExp();
        game.userInput();

    }
}
