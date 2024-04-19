package it.epicode.Player;
// Classe Audio che estende la classe Riprudcibile cosi da passarli anche i metodi
public class Audio extends Riproducibile {

    // construttore per inizializzare
    public Audio (String titolo, int durata){
        this.setTitolo(titolo);
        this.setDurata(durata);
    }


    public void play() {
        super.play(); //richiama metodo da genitore
        for (int i = 0; i < this.getDurata(); i++){
            System.out.print(this.getTitolo());
            // per ogni 'minuto di durata', stampa i titolo

            for (int j = 0; j < this.getVolume(); j++){
                System.out.print("!");
                // per ogni valore di volume', stampa un !
            }
            System.out.println(".");
            // alla fine ad a tutto stampa il "." lo fa in linea perche c'è scritto print(che lo fa in linea )
        }
    }



}


/*
    Classe finale per gli Audio
 */