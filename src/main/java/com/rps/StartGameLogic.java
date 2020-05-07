package com.rps;

public class StartGameLogic {
    private String nick;
    private int winRounds;

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setWinRounds(int winRounds) {
        this.winRounds = winRounds;
    }

    public String getNick() {
        return nick;
    }

    public int getWinRounds() {
        return winRounds;
    }
}
