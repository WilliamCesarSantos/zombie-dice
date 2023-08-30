package br.btg.zombiedice.model.zombie;

import br.btg.zombiedice.model.die.Die;
import br.btg.zombiedice.model.die.DieValue;

public class UnluckyZombie extends Zombie {

    public UnluckyZombie(String name) {
        super(name);
    }

    @Override
    protected void countDie(Die die, DieValue dieValue) {
        if (dieValue == DieValue.BRAIN) {
            dices.add(die);
            brainCount += 1;
        } else if (dieValue == DieValue.SHOT) {
            dices.add(die);
            shotCount += 2;
        } else {
            runners.add(die);
        }
    }

}
