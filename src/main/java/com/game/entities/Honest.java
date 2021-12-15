package com.entities;

import com.CardDeck;

import java.util.Random;

public class Honest extends Player{

    public void stealPoints(int points){
        this.score -= points;
    }

    public Honest(CardDeck cards, int id) {
        super(cards, id);
    }
}
