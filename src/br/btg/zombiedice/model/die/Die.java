package br.btg.zombiedice.model.die;

import java.util.Random;

/**
 * Representacao dos dados no jogo
 */
public abstract class Die {

    private DieValue[] sides;
    private Random random = new Random();

    protected Die(DieValue[] sides) {
        this.sides = sides;
    }

    public DieValue roll() {
        Integer bound = sides.length;//Limitador
        Integer index = random.nextInt(bound);
        return sides[index];
    }

}
