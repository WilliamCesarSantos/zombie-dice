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
        List<Pair<Die, DieValue>> diceRolled = player.play(bowl);
        for (Pair<Die, DieValue> pair : diceRolled) {
            dices.add(pair.getKey());
        }
        //Checar se o zombie pode jogar novamente.
        //Para isso ele não deve ter levado 3 tiros ou mais
    }

}
