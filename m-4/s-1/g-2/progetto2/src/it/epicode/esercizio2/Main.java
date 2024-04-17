package it.epicode.esercizio2;

import java.util.Scanner;
import it.epicode.esercizio3.mian;



import static it.epicode.esercizio4.main.esercizio4;


public class Main {
    public static void main(String[] args) {
        stringaPariDispari("heys");
        annoBisestile(400);
        System.out.println(esercizio2(0));
        mian.esercizio3();
        esercizio4();
    }


    public static void stringaPariDispari(String a) {


        int stringa  = a.length();

        if(stringa % 2 == 0 ){
            System.out.println("il numero e pari ");
        }else{
            System.out.println("la stringa e lunga dispari");
        }
    }

    public static boolean  annoBisestile(int a) {

        if((a % 4 == 0 && a % 100 == 0 && a % 400 == 0 )){
            System.out.println("l'anno e bisestile'");
            return  true;
        }else{
            System.out.println("l'anno non bisestile'");
            return false;
        }

    }

    public static String esercizio2(int a) {

        switch (a) {

            case 0:
                return "zero";
            case 1:
                return "uno";
            case 2:
                return "due";
            case 3:
                return "tre";
            default:
                return "numero non valido";
        }
    }



}