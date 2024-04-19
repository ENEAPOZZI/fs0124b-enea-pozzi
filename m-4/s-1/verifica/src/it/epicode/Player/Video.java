package it.epicode.Player;
// oltre ad estendere la classe Riproducibile (con anessi tutti i metodi) li implementiamo anche l'interfaccia
public class Video extends Riproducibile  implements MetodiVisibili{

    private int luminosita = 5;

    // costruttore per creare il video che richiama i metodi della classe genitore
    public  Video (String titolo, int durata ){

        this.setTitolo(titolo);
        this.setDurata(durata);

    }

    // Override perche sto modificando il metodo della classe padre
    @Override
    public void play(){

        //Metodo per ogni 'minuto' di durata ci stampa tanti ! quanto e il volume
        // e tamti * quanto è la luminosita,

        for(int i = 0 ; i< this.getDurata(); i++){

            System.out.print(this.getTitolo()); // ci dice il titolo del video

            for(int x=0; x<this.getVolume(); x++){
                System.out.print("!");
            }

            System.out.println("questo e luminosita"); //solo per dividere in maniera visiva

            for(int e = 0 ; e<luminosita; e++){
                System.out.print("*");
            }
        }

    }

/*
controlla la luminosita che non sia sopra 100 (nel caso lo sia scrive che la luminosita è al max )
la aumenta di 1 ogni volta che che la richiami
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
    controlla la luminosita che non sia sotto 0 (nel caso lo sia scrive che la luminosita è al min )
    la diminuisce di 1 ogni volta che che la richiami
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
qua implento anche i metodo visibili perche deve essere visualizzato anche lui.

play e in override perche e diverso che per gli altri


classe finale per i video
 */