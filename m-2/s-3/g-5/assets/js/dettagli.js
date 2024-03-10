 /********************** CREDENZIALI **********************/
     //per accedere alla pagina add servono le credenziali
    //nome: nome
   // pw : 123
 /********************** CREDENZIALI **********************/



/***************ELABORAZIONE + ESTRAPOLAZIONE-DATI-DELL'URL ***************/

let url = new URLSearchParams(location.search)
let id = url.get('id')

/*************** CHIAMATA-PER-RECUPERO ***************/

fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`,{
    method:'GET',
    headers:{
        'Authorization':"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTEzODJkN2IxMTAwMTkwZTZlNjYiLCJpYXQiOjE3MDk4OTE4OTYsImV4cCI6MTcxMTEwMTQ5Nn0.JD49Aft3WcfWhnvaF0ZZkMyHVYVllezL-qw698SnpII",
    }
})
.then(res => res.json())
.then(telefono => {

/*************** ITERAZIONI-ELEMENTI-PAGINA ***************/

    let img = document.querySelector('#img')
    let nome = document.querySelector('#nome')
    let modello = document.querySelector('#modello')
    let descrizione = document.querySelector('#descrizione')
    let prezzo = document.querySelector('#prezzo')

/*************** ASSEGNAZIONE-VALORI-DI-ELEMENTI-PAGINA ***************/

    img.src = telefono.imageUrl
    nome.innerText = telefono.name
    modello.innerText = telefono.brand
    prezzo.innerText = telefono.price
    descrizione.innerText = telefono.description
    
})


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



