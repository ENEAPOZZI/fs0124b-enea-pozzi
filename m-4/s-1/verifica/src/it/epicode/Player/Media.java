package it.epicode.Player;

public abstract class Media  {

    private String titolo;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}


/*
    Classe piu alta di tutte ha solo le generalita che tutte le classi devono avere,
    appunto e una classe astratta.
 */
