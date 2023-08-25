package br.btg.zombiedice.model;

public class RedDie extends Die {

    public RedDie() {
        super(
                new DieValue[]{
                        DieValue.SHOOT,
                        DieValue.RUNNER,
                        DieValue.BRAIN,
                        DieValue.SHOOT,
                        DieValue.RUNNER,
                        DieValue.SHOOT
                }
        );
    }

}
