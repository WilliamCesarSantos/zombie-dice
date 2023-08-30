package br.btg.zombiedice.model.die;

public class RedDie extends Die {

    public RedDie() {
        super(
                new DieValue[]{
                        DieValue.SHOT,
                        DieValue.RUNNER,
                        DieValue.BRAIN,
                        DieValue.SHOT,
                        DieValue.RUNNER,
                        DieValue.SHOT
                }
        );
    }

}
