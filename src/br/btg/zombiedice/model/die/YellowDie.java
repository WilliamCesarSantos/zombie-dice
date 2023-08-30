package br.btg.zombiedice.model.die;

public class YellowDie extends Die{

    public YellowDie() {
        super(
                new DieValue[]{
                        DieValue.SHOT,
                        DieValue.RUNNER,
                        DieValue.BRAIN,
                        DieValue.SHOT,
                        DieValue.RUNNER,
                        DieValue.BRAIN
                }
        );
    }

}
