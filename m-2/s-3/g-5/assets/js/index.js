
 /********************** CREDENZIALI **********************/
     //per accedere alla pagina add servono le credenziali
    //nome: nome
   // pw : 123
 /********************** CREDENZIALI **********************/


 /*************** RICHIESTA-ELEMENTI ***************/

 
 
    fetch(`https://striveschool-api.herokuapp.com/api/product/`,{

    method:'GET',
    headers:{
        "Authorization":"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTEzODJkN2IxMTAwMTkwZTZlNjYiLCJpYXQiOjE3MDk4OTE4OTYsImV4cCI6MTcxMTEwMTQ5Nn0.JD49Aft3WcfWhnvaF0ZZkMyHVYVllezL-qw698SnpII",
    },

  

})
.then(res => res.json())
.then(telefoni => {

    /*************** SCOMPARSA-DEL-LOADER ***************/
    
   // setTimeout(() => { questo è il set timeout per vedere meglio il loader c'è anche la parte sotto 
    document.getElementById('loader').style.display = 'none';

    for(let telefono of telefoni){

        /*************** RICHIAMO-FUNZIONE-CLONE-TEMPLATE ***************/

        let card = generaClone()
    
        /*************** ITERAZIONE-ELEMENTI-CARD ***************/   

        let nome = card.querySelector('#nome')
        let modello = card.querySelector('#modello')
        let descrizione = card.querySelector('#descrizione')
        let prezzo = card.querySelector('#prezzo')
        let img = card.querySelector('#img')
        
        /*************** ITERAZIONE-BOTTONI-CARD ***************/ 

        let modificaBtn = card.querySelector('#modifica')
        let scopriBtn = card.querySelector('#scopri')
        let eliminaBtn = card.querySelector('#elimina')
        
        
        /*************** ASSEGNAZIONE-VALORI-ELEMENTI-CARD ***************/     
        
        img.src = telefono.imageUrl
        nome.innerText = telefono.name
        modello.innerText = telefono.brand
        prezzo.innerText = telefono.price + '$'
        descrizione.innerText = telefono.description

        /*************** ASSEGNAZIONE-VALORI-SPECIAL/BOTTINI-ELEMENTI-CARD ***************/     

        modificaBtn.href = `edit.html?id=${telefono._id}`

        scopriBtn.href = `dettagli.html?id=${telefono._id}`

        
    

        
        /*************** ELEMENTI-CARD/BOTTONE-ELIMINA + CHIAMATA/CONFERMA ***************/   

        eliminaBtn.addEventListener('click',function(){

            let conferma = confirm("Sei sicuro di voler eliminare,l'elemente?");
            if(conferma){
                fetch(`https://striveschool-api.herokuapp.com/api/product/${telefono._id}`,{
                    method:'DELETE',
                    headers:{
                        'Content-type':'application/json',
                        'Authorization':"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTEzODJkN2IxMTAwMTkwZTZlNjYiLCJpYXQiOjE3MDk4OTE4OTYsImV4cCI6MTcxMTEwMTQ5Nn0.JD49Aft3WcfWhnvaF0ZZkMyHVYVllezL-qw698SnpII",
                    }
                })
                .then(res => res.json())
                .then(telfonodel => {
                    
                    eliminaBtn.closest('.card').remove()
                })
            }
    
        })

        /*********** INSERIMENTO-IN-PAG-DELLA-CARD ************/   

        document.querySelector('#prodotti').append(card)


      

    }

   // }, 3000) questo è il set timeout per vedere il loader
    
    
})

    /*************** FUNZIONE-CLONE-TEMPLATE ***************/

 function generaClone(){
    
    let template = document.querySelector('#template')
    let clone = template.content.cloneNode(true)

    return clone;
}




/*************** FORM-AUTENTICAZIONE ***************/

let addBtn = document.getElementById('add')
let formAcc = document.getElementById('formAcc')

let exitBtn = document.getElementById('exit')

let nomeFormAcc = document.getElementById('nomeFormAcc') 
let pwFormAcc = document.getElementById('pwFormAcc') 

let btnFormAcc =  document.getElementById('btnFormAcc') 


addBtn.addEventListener('click', function(e){
    e.preventDefault();

    formAcc.classList.remove('d-none')
    formAcc.classList.add('d-block')


    btnFormAcc.addEventListener('click',function(e){
        e.preventDefault();
        if(nomeFormAcc.value === 'nome' && pwFormAcc.value === '123' ){
              
            location.href = './add.html'

        }else{
            alert('nome utente o pas sbagliata ')
        }


    })

    exitBtn.addEventListener('click',function(e){
        e.preventDefault();
       
        formAcc.classList.remove('d-block')
        formAcc.classList.add('d-none')


    })

})


