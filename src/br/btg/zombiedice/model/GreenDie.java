package br.btg.zombiedice.model;

public class GreenDie extends Die {

    public GreenDie() {
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
