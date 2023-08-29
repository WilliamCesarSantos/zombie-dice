package br.btg.zombiedice;

import br.btg.zombiedice.model.*;

import java.util.Arrays;
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
        bowl.put(new GreenDie());
        bowl.put(new RedDie());

        Zombie beatriz = new Zombie("Beatriz");
        Zombie camila = new Zombie("Camila");
        Zombie feliciane = new Zombie("Feliciane");
        Zombie thais = new Zombie("Thais");
        Zombie carol = new Zombie("Carol");
        Zombie jessica = new Zombie("Jessica");
        Game game = new Game(bowl, Arrays.asList(
                beatriz, camila, feliciane, thais, carol, jessica
        ));
        game.start();
    }
}
