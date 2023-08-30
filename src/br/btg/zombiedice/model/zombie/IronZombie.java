package br.btg.zombiedice.model.zombie;

import br.btg.zombiedice.model.die.Die;
import br.btg.zombiedice.model.die.DieValue;

/**
 * extends = herança
 */
public class IronZombie extends Zombie {

    public IronZombie(String name) {
        super(name);
    }

    @Override
    protected void countDie(Die die, DieValue dieValue) {
        if (dieValue == DieValue.BRAIN) {
            dices.add(die);
            brainCount += 1;
        } else if (dieValue == DieValue.SHOT) {
            dices.add(die);
            System.out.println("Zombie de ferro não leva tiro!");
        } else {
            runners.add(die);
        }
    }

}
