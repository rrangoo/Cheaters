package com.entities;

import com.CardDeck;

public class Cheater extends Player{


    public Cheater(CardDeck cards, int id) {
        super(cards, id);
    }

    @Override
    public void run() {
        log("join.");
        while (!Thread.currentThread().isInterrupted()) {

            if ((random.nextInt(11) + 1) > 4){
                log("try to take card. . .");
                synchronized (cards){
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
            } else {
                try {
                    log("try to steal card. . .");
                    synchronized (cards){
                        log("start to steal card. . .");
                        score += cards.stealPoints();
                        log("steal successfully!");
                    }
                    log("sleep. . .");
                    sleep(random.nextInt(121) + 180);
                    log("wake up");
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
        log("finished.");
    }

    private void log(String line) {
        System.out.println("Player " + id + ": " + line);
    }
}
