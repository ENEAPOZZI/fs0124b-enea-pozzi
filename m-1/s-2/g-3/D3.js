const starWarsCharacters = [
    {
      name: 'Luke Skywalker',
      height: 172,
      mass: 277,
      hair_color: 'blond',
      skin_color: 'fair',
      eye_color: 'blue',
      birth_year: '19BBY',
      gender: 'male',
    },
    {
      name: 'C-3PO',
      height: 167,
      mass: 75,
      hair_color: 'n/a',
      skin_color: 'gold',
      eye_color: 'yellow',
      birth_year: '112BBY',
      gender: 'n/a',
    },
    {
      name: 'R2-D2',
      height: 96,
      mass: 32,
      hair_color: 'n/a',
      skin_color: 'white, blue',
      eye_color: 'red',
      birth_year: '33BBY',
      gender: 'n/a',
    },
    {
      name: 'Darth Vader',
      height: 202,
      mass: 136,
      hair_color: 'none',
      skin_color: 'white',
      eye_color: 'yellow',
      birth_year: '41.9BBY',
      gender: 'male',
    },
    {
      name: 'Leia Organa',
      height: 150,
      mass: 49,
      hair_color: 'brown',
      skin_color: 'light',
      eye_color: 'brown',
      birth_year: '19BBY',
      gender: 'female',
    },
    {
      name: 'Owen Lars',
      height: 178,
      mass: 120,
      hair_color: 'brown, grey',
      skin_color: 'light',
      eye_color: 'blue',
      birth_year: '52BBY',
      gender: 'male',
    },
    {
      name: 'Beru Whitesun lars',
      height: 165,
      mass: 75,
      hair_color: 'brown',
      skin_color: 'light',
      eye_color: 'blue',
      birth_year: '47BBY',
      gender: 'female',
    },
    {
      name: 'R5-D4',
      height: 97,
      mass: 32,
      hair_color: 'n/a',
      skin_color: 'white, red',
      eye_color: 'red',
      birth_year: 'unknown',
      gender: 'n/a',
    },
    {
      name: 'Biggs Darklighter',
      height: 183,
      mass: 84,
      hair_color: 'black',
      skin_color: 'light',
      eye_color: 'brown',
      birth_year: '24BBY',
      gender: 'male',
    },
    {
      name: 'Obi-Wan Kenobi',
      height: 182,
      mass: 77,
      hair_color: 'auburn, white',
      skin_color: 'fair',
      eye_color: 'blue-gray',
      birth_year: '57BBY',
      gender: 'male',
    },
  ]
  
  /* ESERCIZIO 1
    Crea una variabile chiamata "charactersNames" e assegnale un array vuoto
  */
  let charactersNames = [];
  /* ESERCIZIO 2
    Utilizzando un ciclo for, cicla l'array "starWarsCharacters".
    Dovrai accedere alla proprietà "name" di ogni oggetto in esso contenuto, e inserirla nell'array "charactersNames" creato precedentemente.
    Come risultato dovresti ottenere qualcosa di simile: ["Luke Skywalker", "C-3PO", "R2-D2", etc..]
  */


for(  let i = 0; i < starWarsCharacters.length ; i++ ){

    charactersNames.push(starWarsCharacters[i].name)

}

console.log(charactersNames);


  
  /* ESERCIZIO 3
    Seguendo i passaggi precedenti crea un nuovo array chiamato "femaleCharacters" e inserisci al suo interno tutti gli oggetti femminili.
  */
  
    let femaleCharacters = [];


    for(  let i = 0; i < starWarsCharacters.length ; i++ ){

        if(starWarsCharacters[i].gender == 'female'){

            femaleCharacters.push(starWarsCharacters[i].name)
        }
    
    } 

    console.log(femaleCharacters);



  /* ESERCIZIO 4
    Crea un oggetto "eyeColor" che abbia le seguenti proprietà: blue, yellow, brown, red, blue-gray.
    Ad ognuna di queste proprietà assegna come valore un array vuoto.
  */

    var eyeColor = {

        blue : [],
        yellow:  [],
        brown : [],
        red   :  [],
        blueGray :  [],



    };

   
  /* ESERCIZIO 5
    Utilizza uno switch statement per inserire uno ad uno gli oggetti dei personaggi di "starWarsCharacters" negli array relativi al colore degli occhi precedentemente creati.
    Ogni personaggio dovrà finire nell'array corrispondente al suo colore degli occhi (al valore della sua proprietà "eye_color").
  */




    switch(starWarsCharacters == true){

        case (starWarsCharacters.eye_color == 'blue') :

        eyeColor.blue.push(starWarsCharacters);


        case (starWarsCharacters.eye_color == 'yellow') :

        eyeColor.yellow.push(starWarsCharacters);


        case (starWarsCharacters.eye_color == 'brown') :

        eyeColor.brown.push(starWarsCharacters);



        case (starWarsCharacters.eye_color == 'red') :

        eyeColor.red.push(starWarsCharacters);


        case (starWarsCharacters.eye_color == 'blueGray') :

        eyeColor.blueGray.push(starWarsCharacters);

    }

    console.log(eyeColor)

  
  /* ESERCIZIO 6
    Usa un while loop per calcolare la massa totale dell'equipaggio. Salvala in una variabile chiamata "crewMass".
  */

    let crewMass= 0;
    let ES6= 0;


    while ( ES6 < starWarsCharacters.length  ){

        crewMass += starWarsCharacters[ES6].mass

        ES6++
    }


    console.log('la massa totale è: ' + crewMass)



  /* ESERCIZIO 7
    Crea uno if/else statement per rivelare la tipologia di carico, utilizzando la massa totale, di un'ipotetica astronave contenente i personaggi dell'array "starWarsCharacters".
  
    Se la massa è inferiore a 500 stampa in console: "Ship is under loaded"
    Se la massa è superiore a 500 e inferiore a 700 stampa in console: "Ship is half loaded"
    Se la massa è superiore a 700 e inferiore a 900 stampa in console: "Warning: Load is over 700"
    Se la massa è superiore a 900 e inferiore a 1000 stampa in console: "Critical Load: Over 900"
    Se la massa è superiore a 1000 stampa in console: "DANGER! OVERLOAD ALERT: escape from ship now!"
  
    Una volta fatto, modifica la massa di qualche elemento dell'equipaggio e vedi se riesci ad ottenere un messaggio diverso.
  */
  

    if(crewMass < 500 ){
        console.log("Ship is under loaded")
    }else if ( crewMass>500 && crewMass <700 ){
        console.log("Ship is half loaded")
    }else if ( crewMass>700 && crewMass <900 ){
        console.log("Warning: Load is over 700")
    }else if ( crewMass>900 && crewMass <1000 ){
        console.log("Critical Load: Over 900")
    }else if ( crewMass> 1000 ){
        console.log("DANGER! OVERLOAD ALERT: escape from ship now!")
    }

  /* ESERCIZIO 8
    Usa un for loop per cambiare il valore della proprietà "gender" di alcuni personaggi dal valore "n/a" a "robot" (Tip: puoi effettuare la riassegnazione del valore corrispondente o creare un nuovo array)
  */

    
    for(let i = 0 ; i < starWarsCharacters.length ; i++){

            if(starWarsCharacters[i].gender == "n/a" ){
                starWarsCharacters[i].gender = "robot"
            }

    }
  

    console.log(starWarsCharacters)


  /* --EXTRA-- ESERCIZIO 9
    Utilizzando gli elementi presenti nell'array "femaleCharacters" rimuovi dall'array "charactersNames" le stringhe corrispondenti a personaggi con lo stesso nome.
    Una volta fatto crea un console.log per controllare la proprietà length di "charactersNames" prima e dopo l'operazione.
  */



for(let ES9 = 0 ; ES9 <starWarsCharacters.length;  ES9 ++ ){

   if(starWarsCharacters[ES9].name === femaleCharacters[0]){

        starWarsCharacters.splice(ES9,1)
      

    }else if(starWarsCharacters[ES9].name === femaleCharacters[1]){

        starWarsCharacters.splice(ES9,1)


    }

}   


console.log(starWarsCharacters.length)



  
  /* --EXTRA-- ESERCIZIO 10
    Crea una funzionalità che selezioni unjjjj elemento casuale dall'array "starWarsCharacters" e ne stampi in console le proprietà in modo discorsivo (a tuo piacimento).
  */
  



    function ES10 (){


        num10 = Math.round(Math.random()*7)+1;


        if(num10 < 9){

            console.log('ciao sono '+  starWarsCharacters[num10].name + ' alto ' + starWarsCharacters[num10].height + ' e peso ' + starWarsCharacters[num10].mass + ' ho i capelli di color: ' + starWarsCharacters[num10].hair_color )
        }
    }


        ES10()