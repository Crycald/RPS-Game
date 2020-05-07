package com.rps.logic;

import com.rps.Items;
import com.rps.StartGame;
import java.util.Scanner;

public class Game {
    private StartGame startGame = new StartGame();
    private Items items;
    private Scanner data = new Scanner(System.in);

    private void consoleInfoNick() {
        System.out.println("Your nick: ");
        String nick = data.nextLine();
        startGame.setNick(nick);
    }

    private void consoleInfoRounds() {
        System.out.println("Rounds: ");
        int rounds = data.nextInt();
        startGame.setWinRounds(rounds);
    }

    public void controlHandler() {
        int item = data.nextInt();
        char letter = data.next().charAt(0);
            switch (item) {
                case 1:
                    System.out.println(items.ROCK);
                    break;
                case 2:
                    System.out.println(items.PAPER);
                    break;
                case 3:
                    System.out.println(items.SCISSORS);
                    break;
            }

        switch (letter) {
            case 'x':
                System.out.println("You rly want end the game? [y/n]");
                if (data.next().charAt(0) == 'y') {
                    endTheGame();
                } else if (data.next().charAt(0) == 'n') {
                    continueTheGame();
                }
                break;
            case 'n':
                System.out.println("Restart game? [y/n]");
                if (data.next().charAt(0) == 'y') {
                    startTheGame();
                } else if (data.next().charAt(0) == 'n') {
                    continueTheGame();
                }
                break;
        }
    }

    public void endTheGame() {
        System.out.println("End Of The Game!");
    }

    public void continueTheGame() {
        System.out.println("Let's back to the game!");
    }

    private void startTheGame() {
        System.out.println(startGame.getRulesFile());
        consoleInfoNick();
        consoleInfoRounds();
        System.out.println(startGame.getControllsFile());
        System.out.println("Game starts");
        controlHandler();
    }

    public void Start() {
        startTheGame();

    }
}
