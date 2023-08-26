package br.btg.zombiedice.model;

import java.util.List;

/**
 * Representação do jogador
 */
public class Zombie {

    private String name;
    private Integer brainCount = 0;
    private Integer shootCount = 0;

    public Zombie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getBrainCount() {
        return brainCount;
    }

    public Integer getShootCount() {
        return shootCount;
    }

    public void play(Bowl bowl) {
        List<Die> dice = bowl.pickDice(3);
        for (Die die : dice) {
            DieValue dieSide = die.roll();
            System.out.println(name + ", o valor sorteado foi: " + dieSide);
        }
    }

}
