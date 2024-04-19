package it.epicode.Player;
// implementa la classe piu alta ed implementa i metodo dentro i metodo visibili
public class Immagine extends Media implements MetodiVisibili{

    private int luminosita = 5 ;

    // rendo disponibile la luminosita
    public int getLuminosita() {
        return luminosita;
    }


    // costruttore per inizializzare il titolo dell'immagine
    public  Immagine (String titolo){
        this.setTitolo(titolo);
    }
    // metodo per mostrare a schermo l'immagine
    public void show(){
        System.out.print("Ecco il titolo:" + this.getTitolo());
        for(int i = 0 ; i < this.getLuminosita(); i++){
            System.out.print("*");//per ogni "punto" della luminosita stamoa un "*", il tutto grazie al ciclo for.
        };
    }

    /*
      controlla che la luminosita non sia a 100 (nel caso ti dice che è al max),
      aumentta il valore di luminosita di 1
     */

    @Override
    public void alzaLuminosita() {
        if(luminosita<100){
            luminosita++;
        }else{
            System.out.println("luminosita al max");
        }
    }

    /*
      controlla che la luminosita non sia a 0 (nel caso ti dice che è al min),
      aumentta il valore di luminosita di 1
     */

    @Override
    public void abbasaLuminosita() {
        if(luminosita > 0){
            luminosita--;
        }else{
            System.out.println("luminosita al min");
        }
    }
}


/*
    classe finale per le classi 
 */