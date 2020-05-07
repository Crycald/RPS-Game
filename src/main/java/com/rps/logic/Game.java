package com.rps.logic;

import com.rps.Items;
import com.rps.StartGame;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private StartGame startGame = new StartGame();
    private Scanner data = new Scanner(System.in);
    private Items items = new Items();
    private int aiPoints = 0;
    private int playerPoints = 0;
    private final static String ROUND_DRAW = "Round Draw";

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

    public String controlHandler() {
        String playerName = startGame.getNick();
        String selectedWeapon = "";
        String input = data.nextLine();
            switch (input) {
                case "1":
                    System.out.println(playerName + ": " + items.ROCK);
                    selectedWeapon = items.ROCK;
                    aiRandomSelect();
                    break;
                case "2":
                    System.out.println(playerName + ": " + items.PAPER);
                    selectedWeapon = items.PAPER;
                    aiRandomSelect();
                    break;
                case "3":
                    System.out.println(playerName + ": " + items.SCISSORS);
                    selectedWeapon = items.SCISSORS;
                    aiRandomSelect();
                    break;
                case "x":
                    System.out.println("You rly want end the game? [y/n]");
                    if (data.next().charAt(0) == 'y') {
                        endTheGame();
                    } else if (data.next().charAt(0) == 'n') {
                        continueTheGame();
                    }
                    break;
                case "n":
                    System.out.println("Restart game? [y/n]");
                    if (data.next().charAt(0) == 'y') {
                        restartGame();
                    } else if (data.next().charAt(0) == 'n') {
                        continueTheGame();
                    }
                    break;
            }
            return selectedWeapon;
    }

    private void endTheGame() {
        System.out.println("End Of The Game!");
        System.exit(0);
    }

    private void continueTheGame() {
        System.out.println("Let's back to the game!");
    }

    private void restartGame() {
        aiPoints = 0;
        playerPoints = 0;
        start();
    }

    private void initConsoleInfo() {
        System.out.println(startGame.getRulesFile());
        consoleInfoNick();
        consoleInfoRounds();
        System.out.println(startGame.getControllsFile());
        System.out.println("------------------");
        System.out.println("");
        System.out.println("Game starts!");
    }

    public String aiRandomSelect() {
        Random random = new Random();
        String aiName = startGame.getAiNick();
        int maxRange = items.listOfItems().size();
        String aiWeapon = items.listOfItems().get(random.nextInt((maxRange - 0) + 1)).toString();

        System.out.print(aiName + ": " + aiWeapon);
        return aiWeapon;
    }

    public void gameLogic() {
        if (controlHandler().contains(items.SCISSORS) && aiRandomSelect().contains(items.SCISSORS)) {
            System.out.println(ROUND_DRAW);
        } else if (controlHandler().contains(items.SCISSORS) && aiRandomSelect().contains(items.PAPER)) {
            playerPoints += 1;
        } else if (controlHandler().contains(items.SCISSORS) && aiRandomSelect().contains(items.ROCK)) {
            aiPoints += 1;
        } else if (controlHandler().contains(items.PAPER) && aiRandomSelect().contains(items.PAPER)) {
            System.out.println(ROUND_DRAW);
        } else if (controlHandler().contains(items.PAPER) && aiRandomSelect().contains(items.ROCK)) {
            playerPoints += 1;
        } else if (controlHandler().contains(items.PAPER) && aiRandomSelect().contains(items.SCISSORS)) {
            aiPoints += 1;
        } else if (controlHandler().contains(items.ROCK) && aiRandomSelect().contains(items.ROCK)) {
            System.out.println(ROUND_DRAW);
        } else if (controlHandler().contains(items.ROCK) && aiRandomSelect().contains(items.SCISSORS)) {
            playerPoints += 1;
        } else if (controlHandler().contains(items.ROCK) && aiRandomSelect().contains(items.PAPER)) {
            aiPoints += 1;
        }
    }

    public void start() {
        boolean end = false;
        while (!end) {

        }
    }
}
