package br.btg.zombiedice;

import br.btg.zombiedice.model.Die;
import br.btg.zombiedice.model.RedDie;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Die die = new RedDie();
        System.out.println("O valor sorteado foi: "+die.roll());
    }

}
