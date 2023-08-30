package br.btg.zombiedice.model.game;

import br.btg.zombiedice.model.bowl.Bowl;
import br.btg.zombiedice.model.round.Round;
import br.btg.zombiedice.model.zombie.Zombie;

import java.util.List;

/**
 * O jogo acontecendo, até que seja atingido o final (Algum jogador tenha chego a 13 cerebros)
 */
public class Game {

    //Constante
    public static final Integer AMOUNT_DICE_TO_PLAY = 3;
    private static final Integer AMOUNT_BRAIN_TO_WIN = 13;

    private Bowl bowl;
    private List<Zombie> zombies;

    /**
     * Posicao do jogador ativo na lista de jogadores(zombies)
     */
    private Integer zombieIndex = 0;

    public Game(Bowl bowl, List<Zombie> zombies) {
        this.bowl = bowl;
        this.zombies = zombies;
    }

    public void start() {
        for (zombieIndex = 0; zombieIndex < zombies.size(); zombieIndex++) {
            Zombie zombiePlaying = zombies.get(zombieIndex);
            System.out.println(zombiePlaying.getName() + " sua vez de jogar, prepara-se!");
            Round round = new Round(zombiePlaying, this);
            round.play(bowl);
            if (win(zombiePlaying)) {
                break;
            } else if (zombieIndex == zombies.size() - 1) {
                //Chegamos ao final da lista, reinicia o loop
                zombieIndex = -1;
            }
        }
    }

    public Boolean win(Zombie zombie) {
        return zombie.getBrainCount() >= AMOUNT_BRAIN_TO_WIN;
    }

}
