package br.btg.zombiedice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representação do turno
 */
public class Round {

    private List<Pair<Die, DieValue>> dices = new ArrayList<>();
    private List<Die> runners = new ArrayList<>();
    private Zombie zombie;

    public Round(Zombie zombie) {
        this.zombie = zombie;
    }

    public void play(Bowl bowl) {
        List<Pair<Die, DieValue>> diceRolled = zombie.play(bowl, runners);
        runners.clear();
        for (Pair<Die, DieValue> dieRolled : diceRolled) {
            dices.add(dieRolled);
            if (dieRolled.getValue() == DieValue.BRAIN) {
                zombie.gotBrain();
            } else if (dieRolled.getValue() == DieValue.SHOOT) {
                zombie.targeted();
            } else {
                runners.add(dieRolled.getKey());
            }
        }
        if (keepPlaying()) {
            play(bowl);
        } else {
            zombie.consolidate(this);
            for (Pair<Die, DieValue> dieRolled : dices) {
                bowl.put(dieRolled.getKey());
            }
        }
    }

    /**
     * A quantidade de cerebros consumidas nesse turno
     * @return
     */
    public Integer getBrainAccount(){
        Integer counter = 0;
        for (Pair<Die, DieValue> dieRolled : dices) {
            if (dieRolled.getValue() == DieValue.BRAIN) {
                counter += 1;
            }
        }
        return counter;
    }

    private Boolean keepPlaying() {
        Boolean keepPlaying = true;
        if (zombie.getBrainCount() >= 13) {
            System.out.println(zombie.getName() + " parabens, você foi o vencedor!");
            keepPlaying = false;
        } else if (zombie.getShootCount() >= 3) {
            System.out.println(zombie.getName() + ", você perdeu esse turno!");
            keepPlaying = false;
        } else {
            System.out.println("Nesse round você levou " +
                    zombie.getShootCount() + " tiros e consumiu " +
                    zombie.getBrainCount() + " cerebros.");
            System.out.println("Deseja jogar novamente(s/n)?");
            Scanner scanner = new Scanner(System.in);
            String userOption = scanner.nextLine();
            keepPlaying = userOption.equalsIgnoreCase("s");
        }
        return keepPlaying;
    }

}
