/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato.
*/

function area (l1, l2){

    return  l1 * l2;

   
    
}


console.log(area(5,8))


/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/

function crazySum (n1,n2){

    if(n1 === n2){
        return (n1+n2)*3
    }else{
        return n1+n2
    }
}


console.log(crazySum(7,5))





/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/

function  crazyDiff (n1, n2 = 19){

    if(n1 < n2){
        return n2 - n1
    }else{
        return (n1-n2)*3
    }

}


console.log(crazyDiff(20))




/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, e ritorna true se n è compreso tra 20 e 100 (incluso) oppure
 se n è uguale a 400.
*/

function  boundary (n1){

    if(n1 >= 20 && n1 <= 100 ||n1 === 400 ){
        return true
    }else{
        return false
    }

}


console.log(boundary(450))


/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa fornita comincia già con "EPICODE" allora deve
 ritornare la stringa originale senza alterarla.
*/


function epify ( text ){
    if( typeof text === "string"){

        if( text.search('EPICODE') === 0 ){
            return text
        }else{
            return ' EPICODE ' + text

        }

    }else{
        return false 
    }
}


console.log(epify ('EPICODE bello '))





/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare che il parametro sia un multiplo
 di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/

function check3and7 (n1){

    if ( (n1 % 3) == 0 || (n1 % 7) == 0 ){
        

        return n1 + ' e divisibile per 3 o 7'
    }else{
        return n1 +  ' non e divisibile per 3 o 7'
    }
}



console.log(check3and7 (50))



/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/

function reverseString (text){

    if( typeof text === "string"){

        let a  = text.split('')
        
        a.reverse()

        let b = a.join('')
         
       return b 


    }else{
        return false 
    }
}

console.log(reverseString ('hey'))

/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/
function upperFirst (text){

    if( typeof text === "string"){

        let a = text.split(" ")


        for(let i = 0; i <a.length; i++){


            return a[i][0].toLocaleUpperCase()

        }


    }else{
        return false 
    }


}




console.log(upperFirst('hey come va') )
/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/

function cutString (text){

    let a = text.split(' ')
    
    a.pop()
    a.shift()
    let b = a.join(' ')
    return b



}


console.log(cutString('hey come va tutto bene'))


/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

function giveMeRandom (n){  
    
    arr=[];
  

     for ( let i = 0; i < n ; i++){

        

        let  b =  Math.floor(Math.random()* 10)+1
        if(i <= 10){
            arr.push(b)
        }

        return arr;
     }
      
      
     

}


console.log(giveMeRandom(5))