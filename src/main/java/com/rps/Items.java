package com.rps;

import java.util.ArrayList;
import java.util.List;

public class Items {
    public final static String SCISSORS = "SCISSORS";
    public final static String ROCK = "ROCK";
    public final static String PAPER = "PAPER";
    private final ArrayList rps = new ArrayList();

    public List listOfItems() {
        this.rps.add(SCISSORS);
        this.rps.add(PAPER);
        this.rps.add(ROCK);

        return rps;
    }
}
