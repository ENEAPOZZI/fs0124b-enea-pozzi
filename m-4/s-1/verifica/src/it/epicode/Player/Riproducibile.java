package it.epicode.Player;
//in questa caso ho implettao l'interfaccia per le classi ripreducibili (per dargli i metodi ) ed esteso la Media.
public abstract class Riproducibile extends Media implements MetodiRiproducibili{

    private int durata ;
    private int volume = 5;


    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getVolume() {
        return volume;
    }


    /* in questo metodo si:
    *  1) controlla che il volume non sia al max,nel cosa scriverà volemi al massimo
    *
    * 2) aumeta il volume di 1 alla volta
    *
    *
    * */

    @Override
    public void aumentaVol() {
        if(volume<100){
            volume++;
        }else{
            System.out.println("volume al max");
        }
    }

    /* in questo metodo si:
     *  1) controlla che il volume non sia al max,nel cosa scriverà volemi al minimo
     *
     * 2) diminuisce il volume di 1 alla volta
     *
     *
     * */

    @Override
    public void riduciVol() {
        if(volume > 0){
            volume--;
        }else{
            System.out.println("volume al min");
        }
    }


}

/*
    Questa è la classe madre  di tutte
    le classe riproducibili.

     Quindi estendo solo qua l'interfaccia della dei metodi riproducibili.
 */
