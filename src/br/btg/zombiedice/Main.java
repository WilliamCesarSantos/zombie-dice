package br.btg.zombiedice;

import br.btg.zombiedice.model.bowl.Bowl;
import br.btg.zombiedice.model.die.GreenDie;
import br.btg.zombiedice.model.die.RedDie;
import br.btg.zombiedice.model.die.YellowDie;
import br.btg.zombiedice.model.game.Game;
import br.btg.zombiedice.model.zombie.IronZombie;
import br.btg.zombiedice.model.zombie.UnluckyZombie;
import br.btg.zombiedice.model.zombie.Zombie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao Zombie-dice, corra enquanto pode!");
        Main init = new Main();
        List<Zombie> zombies = init.registerUsers();
        Bowl bowl = init.createBowl();
        Game game = new Game(bowl, zombies);
        game.start();
        System.out.println("Finalizando o jogo, até a próxima!");
    }

    public List<Zombie> registerUsers() {
        List<Zombie> zombies = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String value = "n";
        do {
            System.out.println("Informe o nome do jogador.");
            String name = scanner.nextLine();
            Boolean isPar = new Random().nextInt() / 2 == 0;
            if (isPar) {
                System.out.println("Vai jogar com o Zombie de ferro");
                zombies.add(new IronZombie(name));
            }else {
                System.out.println("Vai jogar com o Zombie azarado");
                zombies.add(new UnluckyZombie(name));
            }
            System.out.println("Deseja cadastrar um novo jogador(s/n)?");
            value = scanner.nextLine();
        } while (value.equalsIgnoreCase("s"));
        return zombies;
    }

    public Bowl createBowl() {
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
        return bowl;
    }

}
