package br.btg.zombiedice.model.round;

import br.btg.zombiedice.model.bowl.Bowl;
import br.btg.zombiedice.model.bowl.EmptyBowlException;
import br.btg.zombiedice.model.game.Game;
import br.btg.zombiedice.model.zombie.Zombie;

import java.util.Scanner;

/**
 * Representação do turno
 */
public class Round {

    public static final Integer SHOT_LIMIT = 3;

    private Zombie zombie;
    private Integer brainOnRoundStarted = 0;
    private Game game;

    private Scanner scanner = new Scanner(System.in);

    public Round(Zombie zombie, Game game) {
        this.zombie = zombie;
        this.game = game;
        this.brainOnRoundStarted = zombie.getBrainCount();
    }

    public void play(Bowl bowl) {
        try {
            System.out.println("Pressione enter para lançar os dados");
            scanner.nextLine();
            zombie.play(bowl);
            if (keepPlaying()) {
                play(bowl);
            } else {
                zombie.roundEnds(this, bowl);
            }
        } catch (EmptyBowlException ex) {
            System.out.println("Pote vazio, devolvendo os dados");
            zombie.giveBackDice(bowl);
            play(bowl);
        }
    }

    /**
     * A quantidade de cerebros consumidas nesse turno
     *
     * @return
     */
    public Integer brainAte() {
        return zombie.getBrainCount() - brainOnRoundStarted;
    }

    private Boolean keepPlaying() {
        Boolean keepPlaying = true;
        if (game.win(zombie)) {
            System.out.println(zombie.getName() + " parabens, você foi o vencedor!");
            keepPlaying = false;
        } else if (!zombie.isLive()) {
            System.out.println(zombie.getName() + ", você perdeu esse turno!");
            keepPlaying = false;
        } else {
            showInformation();
            keepPlaying = playAgain();
        }
        return keepPlaying;
    }

    protected void showInformation() {
        System.out.println(zombie.getName() + " nesse round você levou "
                + zombie.getShotCount() + " tiros e consumiu "
                + brainAte() + " cerebros.");
    }

    protected boolean playAgain() {
        System.out.println("Deseja jogar novamente(s/n)?");
        String userOption = scanner.nextLine();
        return userOption.equalsIgnoreCase("s");
    }

}
