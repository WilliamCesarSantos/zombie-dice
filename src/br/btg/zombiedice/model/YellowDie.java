package br.btg.zombiedice.model;

public class YellowDie extends Die{

    public YellowDie() {
        super(
                new DieValue[]{
                        DieValue.SHOOT,
                        DieValue.RUNNER,
                        DieValue.BRAIN,
                        DieValue.SHOOT,
                        DieValue.RUNNER,
                        DieValue.BRAIN
                }
        );
    }

}
