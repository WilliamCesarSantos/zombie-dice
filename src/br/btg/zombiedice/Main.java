package br.btg.zombiedice;

import br.btg.zombiedice.model.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Bowl bowl = new Bowl();
        bowl.put(new GreenDie());
        bowl.put(new YellowDie());
        bowl.put(new RedDie());
        bowl.put(new GreenDie());
        bowl.put(new YellowDie());
        bowl.put(new RedDie());
        bowl.put(new GreenDie());
        bowl.put(new YellowDie());
        bowl.put(new RedDie());
        bowl.put(new GreenDie());
        bowl.put(new YellowDie());

        Zombie william = new Zombie("William");
        Round round = new Round(william);
        round.play(bowl);
        System.out.println("Finalizado o jogo, você ganhou!");
    }

}
