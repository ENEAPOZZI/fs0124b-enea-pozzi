package it.epicode;

import java.util.Random;

public class Main {
    public static void main(String[] args) {


            int[] numeri = new int[5];

            for (int i = 0; i < 5; i++) {

                int x = new Random().nextInt(10) + 1; // Genera un numero tra 1 e 10

                numeri[i] = x;
            }

            System.out.println(numeri);
    }



}