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
    private int pointsToWin;
    private String playerSelect, aiSelect;
    private String playerNick;
    private String aiNick = startGame.getAiNick();
    private final static String ROUND_DRAW = "Round Draw";

    public void consoleInfoNick() {
        System.out.println("\n Your nick: ");
        String nick = data.nextLine();
        startGame.setNick(nick);
        this.playerNick = startGame.getNick();
    }

    public void consoleInfoRounds() {
        System.out.println("\n Rounds: ");
        int rns = data.nextInt();
        startGame.setWinRounds(rns);
        this.pointsToWin = startGame.getWinRounds();
    }

    public String getPlayerSelect() {
        return playerSelect;
    }

    public void setAiSelect() {
        Random random = new Random();
        String aiName = startGame.getAiNick();
        int maxRange = items.listOfItems().size();
        this.aiSelect = items.listOfItems().get(random.nextInt((maxRange - 0) + 1)).toString();

        System.out.print(aiName + ": " + aiSelect + "\n");
    }

    public String getAiSelect() {
        setAiSelect();
        return aiSelect;
    }

    public void gainedPointsByPlayers() {
        if (playerPoints == startGame.getWinRounds()) {
            System.out.println("The winner is: " + playerNick);
        } else if (aiPoints == startGame.getWinRounds()) {
            System.out.println("The winner is: " + aiNick);
        }
    }

    public void gameLogic() {
        if (playerSelect.contains(items.SCISSORS) && aiSelect.contains(items.SCISSORS)) {
            System.out.println(ROUND_DRAW);
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.SCISSORS) && aiSelect.contains(items.PAPER)) {
            playerPoints += 1;
            System.out.println(playerNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.SCISSORS) && aiSelect.contains(items.ROCK)) {
            aiPoints += 1;
            System.out.println(aiNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.PAPER) && aiSelect.contains(items.PAPER)) {
            System.out.println(ROUND_DRAW);
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.PAPER) && aiSelect.contains(items.ROCK)) {
            playerPoints += 1;
            System.out.println(playerNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.PAPER) && aiSelect.contains(items.SCISSORS)) {
            aiPoints += 1;
            System.out.println(aiNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.ROCK) && aiSelect.contains(items.ROCK)) {
            System.out.println(ROUND_DRAW);
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.ROCK) && aiSelect.contains(items.SCISSORS)) {
            playerPoints += 1;
            System.out.println(playerNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        } else if (playerSelect.contains(items.ROCK) && aiSelect.contains(items.PAPER)) {
            aiPoints += 1;
            System.out.println(aiNick + " is the winner of this round!");
            System.out.println(playerNick + ": " + playerPoints + " | " + aiNick + ": " + aiPoints);
        }
    }

    public void itemControlHandler() {
        String input = data.nextLine();
            switch (input) {
                case "1":
                    this.playerSelect = items.ROCK;
                    System.out.println(playerNick + ": " + playerSelect);
                    getPlayerSelect();
                    getAiSelect();
                    gameLogic();
                    break;
                case "2":
                    this.playerSelect = items.PAPER;
                    System.out.println(playerNick + ": " + playerSelect);
                    getPlayerSelect();
                    getAiSelect();
                    gameLogic();
                    break;
                case "3":
                    this.playerSelect = items.SCISSORS;
                    System.out.println(playerNick + ": " + playerSelect);
                    getPlayerSelect();
                    getAiSelect();
                    gameLogic();
                    break;
                case "menu":
                    System.out.println("\"x\" - exit game ");
                    System.out.println("\"n\" - restart game");
                    menuControlHandler();
                    break;
            }
    }

    private void menuControlHandler() {
        String input = data.nextLine();
        switch (input) {
            case "x":
                System.out.println("End game? [y/n]" + "\n");
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
        consoleInfoNick();
        //consoleInfoRounds();
        System.out.println(startGame.getControllsFile());
        System.out.println("------------------" + "\n");
        System.out.println("Game starts!" + "\n" + "Select your weapon: ");
    }

    public void start() {
        boolean end = false;
        while (!end) {
            initConsoleGame();
            itemControlHandler();
        }
    }
}
