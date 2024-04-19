package it.epicode;

import it.epicode.Player.Audio;
import it.epicode.Player.Immagine;
import it.epicode.Player.Video;

public class Main {
    //Test generali di funzionamento di tutte le classi e i vari metodi.
    public static void main(String[] args)
    {
        Video primo  = new Video("primo",5);
        Audio primoaudio  = new Audio("primoaudio",5);
        Immagine primoimmagine  = new Immagine("img");

        primo.aumentaVol();
        primo.alzaLuminosita();
        primoimmagine.abbasaLuminosita();



        primoaudio.play();
        primo.play();
        primoimmagine.show();



    }
}