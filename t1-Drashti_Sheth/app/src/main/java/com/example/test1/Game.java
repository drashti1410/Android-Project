package com.example.test1;

import java.io.Serializable;

public class Game implements Serializable {
    int scoreForTigers;
    int scoreForWerewolves;
    String winningTeam;

    public Game(int scoreForTigers, int scoreForWerewolves, String winningTeam) {
        this.scoreForTigers = scoreForTigers;
        this.scoreForWerewolves = scoreForWerewolves;
        this.winningTeam = winningTeam;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    @Override
    public String toString() {
        if (scoreForTigers >=  scoreForWerewolves) {
            return "Tigers: " + scoreForTigers + "-" + "Werewolves: " + scoreForWerewolves;
        } else {
            return "Werewolves: " + scoreForWerewolves + "-" + "Tigers: " + scoreForTigers;
        }
    }
}
