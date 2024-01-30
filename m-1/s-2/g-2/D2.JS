/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/


let num1 = 8;
let num2 = 9;

if( num1 > num2){

    console.log('il numero piu grande e il :' + num1);
}else{
    console.log('il numero piu grande e il :' + num2);

}


/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/

let ES2 = 8;

if(ES2 != 5 ){
    console.log('il numero forsito e not equal');
}else{

    console.log('il numero forsito e 5');
}

/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

let ES3 =  450;
let risultatoSE3= ES3 % 5;


if( risultatoSE3 == 0  ){
   
    console.log('il numero è divisibile per 5 ');

}else{

    console.log('il numero non è  divisibile per 5 ');
}

/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/


let ES4 = 8;
let ES41 = 4;

let ES4add = ES4 + ES41 ;
let ES4sott= ES4 - ES41 ;
let ES4sott2= ES41 - ES4 ;

if( ES4 == 8 || ES41 == 8){
    console.log('Almeno 1 dei due valori dati e 8  ');
}else if ( ES4add == 8 || ES4sott == 8 || ES4sott2 == 8 ){
    console.log('Almeno un operazione o divisione fa come risultato 8');
}







/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

let totalShoppingCart = 100 ;
let costoSpedizione=  10 ; 




if (totalShoppingCart > 50){
    console.log('il  costo totale è :' + totalShoppingCart +' la spedizione la offrimo noi ')
}else{

    totalShoppingCart += 10 ;

    console.log('il  costo totale è :' + totalShoppingCart +' perche con 10 di spedizione ')
}

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/

totalShoppingCart = totalShoppingCart - (totalShoppingCart*20/100);


if (totalShoppingCart > 50){
    console.log('il  costo totale è :' + totalShoppingCart +' la spedizione la offrimo noi ')
}else{

    totalShoppingCart += 10 ;

    console.log('il  costo totale è :' + totalShoppingCart +' perche con 10 di spedizione ')
}


/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

let ES7 =8;
let ES71 =5;
let ES72 =1;
let arrES7 = [];

arrES7.push(ES7,ES71, ES72);

arrES7.sort();

console.log(arrES7);


/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/

let ES8 = 'ciao';
let ES81 = 1 ;

if(typeof ES8 === typeof ES81  ){
    console.log('il valore è un numero ')
}else{
    console.log('il valore  non è un numero ')

}


/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

let ES9 = 5 ;
let ES9Operazione= ES9 % 2 ;

if(ES9Operazione == 0 ){
    console.log('il numero è pari ')
}else{
    console.log('il numero è dispari ')
}

/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
  
*/

let val = 20;


  if ( val < 5 ) {
      console.log("Meno di 5");
    } else if (val < 10 && val >= 5) {
      console.log("Meno di 10");
    } else {
      console.log("Uguale a 10 o maggiore");
    }



/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

const me = {
    name: 'John',
    lastName: 'Doe',
    skills: ['javascript', 'html', 'css'],
  }

  me.city = "Toronto";

  
  console.log(me)
  
  
  /* ESERCIZIO 12
    Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
  */
  
    delete me.lastName;
  
    console.log(me)
  /* ESERCIZIO 13
    Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
  */
  

    me.skills.pop();
  
    console.log(me)


  /* ESERCIZIO 14
    Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
  */
  
  let arrES14 = [];

  arrES14.push(1,2,3,4,5,6,7,8,9,10);

  console.log(arrES14);
  
  /* ESERCIZIO 15
    Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
  */


    arrES14.pop();
    arrES14.push(100);
    console.log(arrES14);
  
  
  