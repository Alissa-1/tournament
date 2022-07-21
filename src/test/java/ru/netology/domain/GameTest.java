package ru.netology.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class GameTest {
    ArrayList<Player> registeredPlayers = new ArrayList<>();
    Game game = new Game(registeredPlayers);

    Player player1 = new Player(1, "Petya", 10);
    Player player2 = new Player(2, "Kolya", 3);
    Player player3 = new Player(3, "Tolya", 5);
    Player player4 = new Player(4, "Player4", 5);

    @Test
    public void shouldRegisterFirstPlayer() {
        game.register(player1);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);

        ArrayList<Player> actual = game.getRegisteredPlayers();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisterSecondPlayer() {
        game.register(player1);
        game.register(player2);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);

        ArrayList<Player> actual = game.getRegisteredPlayers();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisterSecondPlayerIfRepeats() {
        game.register(player1);
        game.register(player2);
        game.register(player2);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);

        ArrayList<Player> actual = game.getRegisteredPlayers();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Player expected = player3;
        Player actual = game.findByName(player3.name);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByName() {
        game.register(player1);
        game.register(player2);

        Player expected = null;
        Player actual = game.findByName(player3.name);
        assertEquals(expected, actual);
    }

    @Test
    public void firstWins() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round(player1.name, player2.name);
        assertEquals(expected, actual);
    }

    @Test
    public void secondWins() {
        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round(player2.name, player3.name);
        assertEquals(expected, actual);
    }

    @Test
    public void equals() {
        game.register(player3);
        game.register(player4);

        int expected = 0;
        int actual = game.round(player3.name, player4.name);
        assertEquals(expected, actual);
    }
}
