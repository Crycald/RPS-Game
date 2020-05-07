package com.rps;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class StartGameTestSuite {
    @Test
    public void shouldReturnNick() {
        StartGame startGame = new StartGame();
        startGame.setNick("shini");
        String nick = "shini";

        Assert.assertEquals(nick, startGame.getNick());
    }

    @Test
    public void shouldReturnCountOfRounds() {
        StartGame startGame = new StartGame();
        startGame.setWinRounds(5);
        int rounds = 5;

        Assert.assertEquals(rounds, startGame.getWinRounds());
    }

    @Test
    public void shouldReadControllsFile() throws FileNotFoundException {
        StartGame startGame = new StartGame();
        String controllsRules = startGame.getControllsFile();
        System.out.println(controllsRules);
    }

    @Test
    public void shouldReadRulesFile() throws FileNotFoundException {
        StartGame startGame = new StartGame();
        String rulesFile = startGame.getRulesFile();
        System.out.println(rulesFile);
    }
}
