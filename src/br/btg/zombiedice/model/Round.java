package br.btg.zombiedice.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representação do turno
 */
public class Round {

    private List<Die> dices = new ArrayList<>();
    private Zombie player;

    public Round(Zombie player) {
        this.player = player;
    }

    public void play(Bowl bowl) {

    }

}
