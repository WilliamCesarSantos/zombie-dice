package br.btg.zombiedice.model;

import java.util.ArrayList;
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

    /**
     * Levou um tiro
     */
    public void targeted() {
        shootCount += 1;
    }

    public void gotBrain() {
        brainCount += 1;
    }

    public List<Pair<Die, DieValue>> play(Bowl bowl, List<Die> runners) {
        // Peguei todos os dados que preciso para jogar
        List<Die> dice = bowl.pickDice(Game.AMOUNT_DICE_TO_PLAY - runners.size());
        dice.addAll(runners);

        List<Pair<Die, DieValue>> used = new ArrayList<>();
        for (Die die : dice) {
            DieValue dieSide = die.roll();
            System.out.println(name + ", o valor sorteado foi: " + dieSide);
            used.add(new Pair<Die, DieValue>(die, dieSide));
        }
        return used;
    }

    public void consolidate(Round round) {

    }

}
