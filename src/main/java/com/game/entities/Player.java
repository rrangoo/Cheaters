package com.entities;

import com.CardDeck;

import java.util.Random;

public abstract class Player extends Thread {

    CardDeck cards;
    int score;
    int id;
    Random random = new Random();

    public void setCards(CardDeck cards) {
        this.cards = cards;
    }

    public int getPlayerId() {
        return id;
    }

    public int getScore() {
        return score;
    }


    public Player(CardDeck cards, int id) {
        this.score = 0;
        this.cards = cards;
        this.id = id;
    }

    @Override
    public void run() {
        log("join.");
        while (!Thread.currentThread().isInterrupted()) {
            log("try to take card. . .");
            synchronized (cards){
                log("start to take card. . .");
                score += cards.getCard();
            }
            log("take card!");
            try {
                log("sleep. . .");
                sleep(random.nextInt(101) + 100);
                log("wake up");
            } catch (InterruptedException e) {
                return;
            }

        }
        log("finished.");
    }

    private void log(String line) {
        System.out.println("Player " + id + ": " + line);
    }
}
