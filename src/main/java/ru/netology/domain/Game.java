package ru.netology.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private ArrayList<Player> registeredPlayers = new ArrayList<>();

    public Game(ArrayList<Player> registeredPlayers) {
        this.registeredPlayers = registeredPlayers;
    }

    public ArrayList<Player> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public void register (Player player) {
        if (!registeredPlayers.contains(player)) {
            registeredPlayers.add(player);
        }
    }

    public Player findByName(String playerName) {
        for (Player registeredPlayer : registeredPlayers) {
            if (registeredPlayer.getName().equals(playerName)) {
                return registeredPlayer;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
