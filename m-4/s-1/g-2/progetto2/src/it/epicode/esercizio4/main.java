package it.epicode.esercizio4;

import java.util.Scanner;

public class main {


    public static void esercizio4(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero per il conto alla rovescia: ");
        int numero = scanner.nextInt();

        for(int i = numero; i >=0 ; i--     ){
            System.out.println(i);

        }

    }
}
