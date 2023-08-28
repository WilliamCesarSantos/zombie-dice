package br.btg.zombiedice.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representação do turno
 */
public class Round {

    private List<Die> dices = new ArrayList<>();
    private List<Die> runners = new ArrayList<>();
    private Zombie zombie;

    public Round(Zombie zombie) {
        this.zombie = zombie;
    }

    public void play(Bowl bowl) {
        List<Pair<Die, DieValue>> diceRolled = zombie.play(bowl, runners);
        for (Pair<Die, DieValue> dieRolled : diceRolled) {
            dices.add(dieRolled.getKey());
            if (dieRolled.getValue() == DieValue.BRAIN) {
                zombie.gotBrain();
            } else if (dieRolled.getValue() == DieValue.SHOOT) {
                zombie.targeted();
            } else {
                runners.add(dieRolled.getKey());
            }
        }
        if (zombie.getShootCount() < 3) {
            play(bowl);
        }
    }

}
