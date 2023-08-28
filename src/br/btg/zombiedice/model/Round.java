package br.btg.zombiedice.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representação do turno
 */
public class Round {

    private List<Die> dices = new ArrayList<>();
    private Zombie zombie;

    public Round(Zombie zombie) {
        this.zombie = zombie;
    }

    public void play(Bowl bowl) {
        List<Pair<Die, DieValue>> diceRolled = zombie.play(bowl);
        for (Pair<Die, DieValue> dieRolled : diceRolled) {
            dices.add(dieRolled.getKey());
            if (dieRolled.getValue() == DieValue.BRAIN) {

            } else if (dieRolled.getValue() == DieValue.SHOOT) {
                zombie.targeted();
            } else {

            }
        }
        if (zombie.getShootCount() < 3) {
            play(bowl);
        }
    }

}
