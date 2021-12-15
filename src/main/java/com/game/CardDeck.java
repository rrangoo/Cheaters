package com;

import com.entities.Cheater;
import com.entities.Honest;
import com.entities.Player;

import java.util.ArrayList;
import java.util.Random;

public class CardDeck {

    Random random = new Random();
    Player[] players;

    public CardDeck(Player[] players){
        this.players = players;
    }

    public synchronized int getCard(){
        return random.nextInt(10) + 1;
    }

    public synchronized int stealPoints(){
        int points = random.nextInt(9);
        Player player;
        do {
            player = players[random.nextInt(players.length)];
            if (player instanceof Honest aim){
                if (aim.getScore() <= points){
                    points = aim.getScore();
                    aim.stealPoints(points);
                    return points;
                } else {
                    aim.stealPoints(points);
                    return points;
                }
            }
        } while (player instanceof Cheater);

        return 0;
    }

}