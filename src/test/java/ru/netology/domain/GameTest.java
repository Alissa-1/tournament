package ru.netology.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

public class GameTest {
    HashMap<String, Integer> registeredPlayers = new HashMap<>();
    Game game = new Game(registeredPlayers);

    @Test
    public void shouldRegisterFirstPlayer() {
        game.register("Petya", 10);

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Petya", 10);

        HashMap<String, Integer> actual = game.getRegisteredPlayers();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisterSecondPlayer() {
        game.register("Petya", 10);
        game.register("Kolya", 3);

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Petya", 10);
        expected.put("Kolya", 3);

        HashMap<String, Integer> actual = game.getRegisteredPlayers();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisterSecondPlayerIfRepeats() {
        game.register("Petya", 10);
        game.register("Kolya", 3);
        game.register("Kolya", 3);

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Petya", 10);
        expected.put("Kolya", 3);

        HashMap<String, Integer> actual = game.getRegisteredPlayers();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByName() {
        game.register("Petya", 10);
        game.register("Kolya", 3);
        game.register("Tolya", 5);

        Integer expected = 5;
        Integer actual = game.findByName("Tolya");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByName() {
        game.register("Petya", 10);
        game.register("Kolya", 3);

        Player expected = null;
        Integer actual = game.findByName("Tolya");
        assertEquals(expected, actual);
    }

    @Test
    public void firstWins() {
        game.register("Petya", 10);
        game.register("Kolya", 3);

        int expected = 1;
        int actual = game.round("Petya", "Kolya");
        assertEquals(expected, actual);
    }

    @Test
    public void secondWins() {
        game.register("Kolya", 3);
        game.register("Tolya", 5);

        int expected = 2;
        int actual = game.round("Kolya", "Tolya");
        assertEquals(expected, actual);
    }

    @Test
    public void equals() {
        game.register("Tolya", 5);
        game.register("Vasya", 5);

        int expected = 0;
        int actual = game.round("Tolya", "Vasya");
        assertEquals(expected, actual);
    }
}
