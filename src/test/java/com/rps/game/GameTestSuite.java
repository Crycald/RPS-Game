package com.rps.game;

import com.rps.logic.Game;
import org.junit.Test;

public class GameTestSuite {
    @Test
    public void shouldShowConsoleInfoNick() {
        Game game = new Game();
        game.consoleInfoNick();
    }
}
