/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
    Dato il seguente array, scrivi del codice per stampare ogni elemento dell'array in console.
*/
const pets = ['dog', 'cat', 'hamster', 'redfish']


for(let i = 0; i<pets.length;i++){

  console.log(pets[i])
}

/* ESERCIZIO 2
    Scrivi del codice per ordinare alfabeticamente gli elementi dell'array "pets".
*/


pets.sort()

console.log(pets)



/* ESERCIZIO 3
    Scrivi del codice per stampare nuovamente in console gli elementi dell'array "pets", questa volta in ordine invertito.
*/



console.log(pets.reverse())



/* ESERCIZIO 4
    Scrivi del codice per spostare il primo elemento dall'array "pets" in ultima posizione.
*/

let a = pets[0]

pets.shift()
pets.push(a)

console.log(pets)



/* ESERCIZIO 5
    Dato il seguente array di oggetti, scrivi del codice per aggiungere ad ognuno di essi una proprietà "licensePlate" con valore a tua scelta.
*/

const cars = [
  {
    brand: 'Ford',
    model: 'Fiesta',
    color: 'red',
    trims: ['titanium', 'st', 'active'],
  },
  {
    brand: 'Peugeot',
    model: '208',
    color: 'blue',
    trims: ['allure', 'GT'],
  },
  {
    brand: 'Volkswagen',
    model: 'Polo',
    color: 'black',
    trims: ['life', 'style', 'r-line'],
  },
]



for(let i = 0 ; i <cars.length;i++ ){

  cars[i].licensePlate = Math.floor(Math.random()*100)

}

console.log(cars)






/* ESERCIZIO 6
    Scrivi del codice per aggiungere un nuovo oggetto in ultima posizione nell'array "cars", rispettando la struttura degli altri elementi.
    Successivamente, rimuovi l'ultimo elemento della proprietà "trims" da ogni auto.
*/

cars.push({
  brand: 'ferrari',
  model: '911',
  color: 'yellow',
  licensePlate : Math.floor(Math.random()*100),
  trims: ['life', 'style', 'r-line'],
})

console.log(cars)

for(let i = 0 ; i <cars.length;i++ ){

  cars[i].trims.pop()

}

console.log(cars)


/* ESERCIZIO 7
    Scrivi del codice per salvare il primo elemento della proprietà "trims" di ogni auto nel nuovo array "justTrims", sotto definito.
*/
const justTrims = []




for(let i = 0 ; i <cars.length;i++ ){

 let ES7 = cars[i].trims[0]

  justTrims.push(ES7)
}


console.log(justTrims)








/* ESERCIZIO 8
    Cicla l'array "cars" e costruisci un if/else statament per mostrare due diversi messaggi in console. Se la prima lettera della proprietà
    "color" ha valore "b", mostra in console "Fizz". Altrimenti, mostra in console "Buzz".
*/




for(let i = 0 ; i <cars.length;i++ ){

  if(cars[i].color[0]==='b'){
    console.log('Fizz')
  }else(
    console.log('Buzz')
  )
 }

/* ESERCIZIO 9
    Utilizza un ciclo while per stampare in console i valori del seguente array numerico fino al raggiungimento del numero 32.
*/
const numericArray = [
    6, 90, 45, 75, 84, 98, 35, 74, 31, 2, 8, 23, 100, 32, 66, 313, 321, 105,
  ]

let num = 0
 while(num < numericArray.length){
    
    if(numericArray[num] != 32){
     
      console.log(numericArray[num])
 
    }

    if(numericArray[num] === 32){
        break
    }

    num++
   
  }
  


  /* ESERCIZIO 10
    Partendo dall'array fornito e utilizzando un costrutto switch, genera un nuovo array composto dalle posizioni di ogni carattere all'interno
    dell'alfabeto italiano.
    es. [f, b, e] --> [6, 2, 5]
*/


const charactersArray = ['h', 'n', 'u', 'z', 'd']


const ES10 = [];


for(let i = 0 ; i < charactersArray.length;i++ ){



    let g =charactersArray[i]

   
   switch(g) {
    
    case 'a' :

     ES10.push(1)

     break

    case  'b':

      ES10.push(2)

     break

    case 'c' :

     ES10.push(3)

     break



    case 'd' :

     ES10.push(4)

     break

    case  'e' :

     ES10.push(5)

     break

    case  'f' :

     ES10.push(6)

     break

    case  'g' :

     ES10.push(7)

     break

    case 'h' :

     ES10.push(8)

     break

    case  'i' :

     ES10.push(9)


     break

    case  'l' :

     ES10.push(10)

     break

    case  'm' :

     ES10.push(11)

     break

    case   'n' :

     ES10.push(12)

     break

    case   'o' :

     ES10.push(13)


     break

    case  'p' :

     ES10.push(14)

     break

    case   'q' :

     ES10.push(15)

     break


    case  'r' :

     ES10.push(16)

     break


    case  's' :

     ES10.push(17)

     break

    case 't' :

     ES10.push(18)

     break


    case  'u' :

     ES10.push(19)


     break


    case  'v' :

     ES10.push(20)

     break

    case   'z' :
     ES10.push(21)
     break
}
}

console.log(ES10)
  
   
   





