package com;

import com.entities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game {

    Player[] players;
    CardDeck cards;
    int count;

    public Game(int count){
        this.count = count;
        players = new Player[count];
        for (int i = 0; i < count; i++) {
            players[i] = i % 2 == 0 ? new Honest(cards, i) : new Cheater(cards, i);
        }

        cards = new CardDeck(players);

        for (int i = 0; i < count; i++) {
            players[i].setCards(cards);

        }
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < count; i++) {
            players[i].start();
        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("SLEEP " + i);
        }

        for (int i = 0; i < count; i++) {
            players[i].interrupt();
        }

        for (Player player:players) {
            System.out.println(player.getPlayerId() + ": " + player.getScore());
        }
    }
}
