package br.btg.zombiedice.model;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * O jogo acontecendo, até que seja atingido o final (Algum jogador tenha chego a 13 cerebros)
 */
public class Game {

    //Constante
    public static final Integer AMOUNT_DICE_TO_PLAY = 3;

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
        System.out.println("Bem vindo ao Zombie-Dice, corra enquanto pode!!");
        for (zombieIndex = 0; zombieIndex < zombies.size(); zombieIndex++) {
            Zombie zombiePlaying = zombies.get(zombieIndex);
            System.out.println(zombiePlaying.getName() + " sua vez de jogar, prepara-se!");
            Round round = new Round(zombiePlaying);
            round.play(bowl);
            if (zombiePlaying.getBrainCount() >= 13) {
                //Encerra a execução do programa
                System.exit(0);
            } else if (zombieIndex == zombies.size() - 1) {
                //Chegamos ao final da lista, reinicia o loop
                zombieIndex = -1;
            }
        }
    }

}
