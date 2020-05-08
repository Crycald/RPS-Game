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
    private int pointsToWin = 5;
    private String playerSelect, aiSelect;
    private String playerNick;
    private String aiNick = startGame.getAiNick();
    private boolean endGame = false;
    private final static String ROUND_DRAW = "Round Draw";

    private void consoleInfoNick() {
        System.out.println("\n Your nick: ");
        String nick = data.nextLine();
        startGame.setNick(nick);
        this.playerNick = startGame.getNick();
    }

    private void consoleInfoRounds() {
        System.out.println("\n Rounds: ");
        int rns = data.nextInt();
        startGame.setWinRounds(rns);
        this.pointsToWin = startGame.getWinRounds();
    }

    private int getPointsToWin() {
        return pointsToWin;
    }

    private String getPlayerSelect() {
        return playerSelect;
    }

    private void setAiSelect() {
        Random random = new Random();
        String aiName = startGame.getAiNick();
        int maxRange = items.listOfItems().size();
        this.aiSelect = items.listOfItems().get(random.nextInt((maxRange - 0) + 1)).toString();

        System.out.print(aiName + ": " + aiSelect + "\n");
    }

    private String getAiSelect() {
        setAiSelect();
        return aiSelect;
    }

    private void gainedPointsByPlayers() {
        if (playerPoints == pointsToWin) {
            System.out.println("\n The winner is: " + playerNick + "\n");
            System.out.println("TYPE: \"x\" - exit game ");
            System.out.println("TYPE: \"n\" - restart game");
            menuControlHandler();
        } else if (aiPoints == pointsToWin) {
            System.out.println("\nThe winner is: " + aiNick + "\n");
            System.out.println("TYPE: \"x\" - exit game ");
            System.out.println("TYPE: \"n\" - restart game");
            menuControlHandler();
        } else if (playerPoints < pointsToWin || aiPoints < pointsToWin) {
            itemControlHandler();
        }
    }

    private void gameLogic() {
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

    private void itemControlHandler() {
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
        gainedPointsByPlayers();
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
                System.out.println("Play again? [y/n]" + "\n");
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
        this.endGame = true;
    }

    private void continueTheGame() {
        System.out.println("Back to the game!");
        itemControlHandler();
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
        consoleInfoRounds();
        System.out.println(startGame.getControllsFile());
        System.out.println("------------------" + "\n");
        System.out.println("Game starts!" + "\n" + "Select your weapon: ");
        itemControlHandler();
    }

    public void start() {
        this.pointsToWin = 2;
        while (!endGame) {
            initConsoleGame();
        }
    }
}
