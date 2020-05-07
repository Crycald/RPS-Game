package com.rps;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StartGame {
    private String nick;
    private final String aiNick = "Computer";
    private int winRounds;
    private Path root = FileSystems.getDefault().getPath("").toAbsolutePath();

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setWinRounds(int winRounds) {
        this.winRounds = winRounds;
    }

    public String getControllsFile() {
        String controllsFile = "";
        try {
            Path filePath = Paths.get(root.toString(), "src", "main", "resources", "controlls.txt");
            controllsFile = new String(Files.readAllBytes(Paths.get(filePath.toString())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return controllsFile;
    }

    public String getRulesFile() {
        String rulesFile = "";
        try {
            Path filePath = Paths.get(root.toString(), "src", "main", "resources", "rules.txt");
            rulesFile = new String(Files.readAllBytes(Paths.get(filePath.toString())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rulesFile;
    }

    public String getNick() {
        return nick;
    }

    public String getAiNick() {
        return aiNick;
    }

    public int getWinRounds() {
        return winRounds;
    }
}
