package it.epicode.esercizio3;

import java.util.Scanner;

public class mian {

    public static char[] esercizio3() {

        String parola = "";

        char[] caratteri = null;
        while (!parola.equals(":q")) {
            System.out.println("inseriesci una parola ");
            parola = new Scanner(System.in).nextLine();
            caratteri = parola.toCharArray();
        }


        return caratteri;

    }
}
