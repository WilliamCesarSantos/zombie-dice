package br.btg.zombiedice.model.zombie;

import br.btg.zombiedice.model.bowl.Bowl;
import br.btg.zombiedice.model.die.Die;
import br.btg.zombiedice.model.die.DieValue;
import br.btg.zombiedice.model.game.Game;
import br.btg.zombiedice.model.round.Round;

import java.util.ArrayList;
import java.util.List;

/**
 * Representação do jogador
 */
public abstract class Zombie {

    private String name;
    protected Integer brainCount = 0;
    protected Integer shotCount = 0;

    protected List<Die> dices = new ArrayList<>();
    protected List<Die> runners = new ArrayList<>();

    public Zombie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getBrainCount() {
        return brainCount;
    }

    public Integer getShotCount() {
        return shotCount;
    }

    public void play(Bowl bowl) {
        // Peguei todos os dados que preciso para jogar
        List<Die> dice = bowl.pickDice(Game.AMOUNT_DICE_TO_PLAY - runners.size());
        dice.addAll(runners);
        runners.clear();

        for (Die die : dice) {
            DieValue dieSide = die.roll();
            System.out.println("Valor sorteado foi: " + dieSide);
            countDie(die, dieSide);
        }
    }

    public void giveBackDice(Bowl bowl) {
        for (Die die : runners) {
            bowl.put(die);
        }
        runners.clear();
        for (Die die : dices) {
            bowl.put(die);
        }
        dices.clear();
    }

    protected abstract void countDie(Die die, DieValue dieValue);

    public boolean isLive() {
        return shotCount < Round.SHOT_LIMIT;
    }

    public void roundEnds(Round round, Bowl bowl) {
        giveBackDice(bowl);
        if (!isLive()) {
            brainCount = brainCount - round.brainAte();
        }
        shotCount = 0;
        showInformation();
    }

    protected void showInformation() {
        System.out.println(name + " até a agora você obteve " + brainCount + " cerebros.");
    }

}
