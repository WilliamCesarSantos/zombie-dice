package br.btg.zombiedice;

import br.btg.zombiedice.model.Die;
import br.btg.zombiedice.model.GreenDie;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Die die = new GreenDie();
        System.out.println("O valor sorteado foi: " + die.roll());
    }

}
