package ru.netology.domain;
import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> registeredPlayers;

    public Game(HashMap<String, Integer> registeredPlayers) {
        this.registeredPlayers = registeredPlayers;
    }

    public HashMap<String, Integer> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public void register (String playerName, Integer strength) {
        if (!registeredPlayers.containsKey(playerName)) {
            registeredPlayers.put(playerName, strength);
        }
    }

    public Integer findByName(String playerName) {
        for (String name : registeredPlayers.keySet()) {
            if (name.equals(playerName)) {
                return registeredPlayers.get(name);
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) > findByName(playerName2)) {
            return 1;
        };
        if (findByName(playerName1) < findByName(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }
}
