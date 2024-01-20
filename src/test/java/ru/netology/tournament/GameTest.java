package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void shouldPlayer1Win() {
        Player alex = new Player(1, "Alex", 100);
        Player jack = new Player(2, "Jack", 200);

        Game game = new Game();

        game.register(alex);
        game.register(jack);

        int expected = 1;
        int actual = game.round("Jack", "Alex");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer2Win() {
        Player alex = new Player(1, "Alex", 100);
        Player jack = new Player(2, "Jack", 200);

        Game game = new Game();

        game.register(alex);
        game.register(jack);

        int expected = 2;
        int actual = game.round("Alex", "Jack");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {
        Player alex = new Player(1, "Alex", 200);
        Player jack = new Player(2, "Jack", 200);

        Game game = new Game();

        game.register(alex);
        game.register(jack);

        int expected = 0;
        int actual = game.round("Alex", "Jack");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer1NotRegistered() {
        Player alex = new Player(1, "Alex", 100);
        Player jack = new Player(2, "Jack", 200);

        Game game = new Game();

        game.register(alex);
        game.register(jack);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sam", "Jack");
        });
    }

    @Test
    public void shouldPlayer2NotRegistered() {
        Player alex = new Player(1, "Alex", 100);
        Player jack = new Player(2, "Jack", 200);

        Game game = new Game();

        game.register(alex);
        game.register(jack);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "Sam");
        });
    }
}