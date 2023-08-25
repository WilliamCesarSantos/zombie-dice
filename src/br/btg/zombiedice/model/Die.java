package br.btg.zombiedice.model;

/**
 * Representacao dos dados no jogo
 */
public abstract class Die {

    private DieValue[] sides;

    protected Die(DieValue[] sides) {
        this.sides = sides;
    }

    public DieValue roll() {

    }

}
