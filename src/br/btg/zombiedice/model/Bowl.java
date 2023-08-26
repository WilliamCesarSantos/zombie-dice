package br.btg.zombiedice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representação do armazenamento dos dados (die)
 */
public class Bowl {

    private List<Die> dice = new ArrayList<Die>();

    public Bowl() {}

    public void put(Die die) {
        dice.add(die);
    }

    public List<Die> pickDice(Integer amount) {
        Collections.shuffle(dice);
        List<Die> buffer = new ArrayList();
        for (int index = 0; index < amount; index++) {
            buffer.add(dice.remove(0));
        }
        return buffer;
    }

}
