package br.btg.zombiedice.model;

public class GreenDie extends Die {

    protected GreenDie() {
        super(
                new DieValue[]{
                        DieValue.BRAIN,
                        DieValue.RUNNER,
                        DieValue.SHOOT,
                        DieValue.BRAIN,
                        DieValue.RUNNER,
                        DieValue.BRAIN
                }
        );
    }

}
