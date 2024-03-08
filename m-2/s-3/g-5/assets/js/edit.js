/*************** SETTING-BOTTONE-DI-RESET ***************/

const btnReset =  document.querySelector('#reset')

btnReset.addEventListener('click',function(){

    let conferma = confirm("Sei sicuro di voler resettare il modulo?");
  
    if (conferma) {
        document.querySelector('#nome').value=''
        document.querySelector('#nome').value=''
        document.querySelector('#modello').value=''
        document.querySelector('#prezzo').value=''
        document.querySelector('#img').value=''
        document.querySelector('#textarea').value=''

    }

})
 
/*************** ELABORAZIONE + ESTRAPOLAZIONE-DATI-DELL'URL ***************/

 let url = new URLSearchParams(location.search)
 let id = url.get('id')

/*************** CHIAMTA-PER-AVERE-DATI ***************/
 
 fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`,{
    method:'GET',
    headers:{
        
        'Authorization':"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTEzODJkN2IxMTAwMTkwZTZlNjYiLCJpYXQiOjE3MDk4OTE4OTYsImV4cCI6MTcxMTEwMTQ5Nn0.JD49Aft3WcfWhnvaF0ZZkMyHVYVllezL-qw698SnpII",
    }
})
 .then(res => res.json())
 .then(telefono => {
     
     let nome = document.querySelector('#nome')
     let modello = document.querySelector('#modello')
     let prezzo = document.querySelector('#prezzo')
     let img = document.querySelector('#img')
     let textarea = document.querySelector('#textarea')
     
     nome.value = telefono.name
     modello.value = telefono.brand
     prezzo.value = telefono.price
     img.value = telefono.imageUrl
     textarea.value = telefono.description
     
 })
 
 
 /*************** SETTING-BOTTONE-DI-SALVATAGGIO + ASSEGNAZIONE-VALORI ***************/

 const salvaBtn =  document.querySelector('#save')

 salvaBtn.addEventListener('click',function(e){
     e.preventDefault()

     let nome = document.querySelector('#nome').value
     let modello = document.querySelector('#modello').value
     let prezzo = document.querySelector('#prezzo').value
     let img = document.querySelector('#img').value
     let textarea = document.querySelector('#textarea').value
     
     let telefono = {
        name:nome,
        brand:modello,
        price:prezzo,
        imgUrl:img,
        description:textarea,
        
    }

    /***************CHIAMATA-DI-MODIFICA-ELEMENTO ***************/
    
    fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`,{
        method:'PUT',
        headers:{
            'Content-type':'application/json',
            'Authorization':"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTEzODJkN2IxMTAwMTkwZTZlNjYiLCJpYXQiOjE3MDk4OTE4OTYsImV4cCI6MTcxMTEwMTQ5Nn0.JD49Aft3WcfWhnvaF0ZZkMyHVYVllezL-qw698SnpII",
        },
        body:JSON.stringify(telefono)
    })
     .then(res => res.json())
     .then(res => {

        window.alert("telefono modificato")

        location.href = './index.html'


     })

 })
