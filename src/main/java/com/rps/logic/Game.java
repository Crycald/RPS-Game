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
    private String playerSelect, aiSelect;
    private String playerNick;
    private String aiNick = startGame.getAiNick();
    private final static String ROUND_DRAW = "Round Draw";

    private void consoleInfoNick() {
        System.out.println("\n Your nick: ");
        String nick = data.nextLine();
        startGame.setNick(nick);
        this.playerNick = startGame.getNick();
        System.out.println("\n Welcome " + playerNick + "\n");
    }

    private void consoleInfoRounds() {
        System.out.println("\n Rounds: ");
        int rounds = data.nextInt();
        startGame.setWinRounds(rounds);
    }

    public String getPlayerSelect() {
        return playerSelect;
    }

    public void setAiSelect() {
        this.aiSelect = aiRandomSelect();
    }

    public String getAiSelect() {
        return aiSelect;
    }

    public void gameLogic() {
        if (getPlayerSelect().contains(items.SCISSORS) && getAiSelect().contains(items.SCISSORS)) {
            System.out.println(ROUND_DRAW);
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (getPlayerSelect().contains(items.SCISSORS) && getAiSelect().contains(items.PAPER)) {
            playerPoints += 1;
            System.out.println(playerNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (getPlayerSelect().contains(items.SCISSORS) && getAiSelect().contains(items.ROCK)) {
            aiPoints += 1;
            System.out.println(aiNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (getPlayerSelect().contains(items.PAPER) && getAiSelect().contains(items.PAPER)) {
            System.out.println(ROUND_DRAW);
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (getPlayerSelect().contains(items.PAPER) && getAiSelect().contains(items.ROCK)) {
            playerPoints += 1;
            System.out.println(playerNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (getPlayerSelect().contains(items.PAPER) && getAiSelect().contains(items.SCISSORS)) {
            aiPoints += 1;
            System.out.println(aiNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.ROCK) && getAiSelect().contains(items.ROCK)) {
            System.out.println(ROUND_DRAW);
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.ROCK) && getAiSelect().contains(items.SCISSORS)) {
            playerPoints += 1;
            System.out.println(playerNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.ROCK) && getAiSelect().contains(items.PAPER)) {
            aiPoints += 1;
            System.out.println(aiNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        }
    }

    public String controlHandler() {
        String input = data.nextLine();
        String playerName = startGame.getNick();
            switch (input) {
                case "1":
                    this.playerSelect = items.ROCK;
                    System.out.println(playerName + ": " + playerSelect);
                    setAiSelect();
                    gameLogic();
                    break;
                case "2":
                    this.playerSelect = items.PAPER;
                    System.out.println(playerName + ": " + playerSelect);
                    setAiSelect();
                    gameLogic();
                    break;
                case "3":
                    this.playerSelect = items.SCISSORS;
                    System.out.println(playerName + ": " + playerSelect);
                    setAiSelect();
                    gameLogic();
                    break;
                case "x":
                    System.out.println("You rly want end the game? [y/n]" + "\n");
                    if (data.next().charAt(0) == 'y') {
                        endTheGame();
                    } else if (data.next().charAt(0) == 'n') {
                        continueTheGame();
                    }
                    break;
                case "n":
                    System.out.println("Restart game? [y/n]" + "\n");
                    if (data.next().charAt(0) == 'y') {
                        restartGame();
                    } else if (data.next().charAt(0) == 'n') {
                        continueTheGame();
                    }
                    break;
            }
            return playerSelect;
    }

    private void endTheGame() {
        System.out.println("Game over!" + "\n");
        System.exit(0);
    }

    private void continueTheGame() {
        System.out.println("Back to the game!");
    }

    private void restartGame() {
        aiPoints = 0;
        playerPoints = 0;
        System.out.println("Game has been restarted...");
        start();
    }

    public void initConsoleGame() {
        System.out.println(startGame.getRulesFile());
        //consoleInfoNick();
        consoleInfoRounds();
        System.out.println(startGame.getControllsFile());
        System.out.println("\n" + "------------------" + "\n");
        System.out.println("\n" + "Game starts!" + "\n" + "Select your weapon: ");
        controlHandler();
    }

    public String aiRandomSelect() {
        Random random = new Random();
        String aiName = startGame.getAiNick();
        int maxRange = items.listOfItems().size();
        this.aiSelect = items.listOfItems().get(random.nextInt((maxRange - 0) + 1)).toString();

        System.out.print(aiName + ": " + aiSelect + "\n");
        return aiSelect;
    }

    public void start() {
        boolean end = false;
        while (!end) {
            initConsoleGame();
        }
    }
}
