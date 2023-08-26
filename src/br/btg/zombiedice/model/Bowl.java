package br.btg.zombiedice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representação do armazenamento dos dados (die)
 */
public class Bowl {

    private List dice = new ArrayList();

    public Bowl() {}

    public void put(Die die) {
        dice.add(die);
    }

    public List pickDice(Integer amount) {
        Collections.shuffle(dice);
        List buffer = new ArrayList();
        for (int index = 0; index < amount; index++) {
            buffer.add(dice.remove(0));
        }
        return buffer;
    }

}
