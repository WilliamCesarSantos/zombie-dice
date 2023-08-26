package br.btg.zombiedice.model;

public class YellowDie extends Die{

    protected YellowDie() {
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
