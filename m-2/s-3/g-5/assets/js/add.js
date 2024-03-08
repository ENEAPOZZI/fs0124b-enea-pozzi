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

const btnSalva =  document.querySelector('#save')

btnSalva.addEventListener('click',function(e){
    e.preventDefault()
/*************** ITERAZIONE-ELEMENTI-FORM ***************/

    let name = document.querySelector('#nome').value
    let brand = document.querySelector('#modello').value
    let price = document.querySelector('#prezzo').value
    let imageUrl = document.querySelector('#img').value
    let description = document.querySelector('#textarea').value

/*************** ASSEGNAZIONE-VALORI-NEW-ELEMENT ***************/

    let telefono = {
        name,
        brand,
        price,
        imageUrl,
        description,
    }

   /*************** CHIAMATA-PER-'POSTARE'-ELEMENTO ***************/

    fetch(`https://striveschool-api.herokuapp.com/api/product/`,{
        method:'POST',
        headers:{
            'Content-type':'application/json',
            "Authorization":"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTEzODJkN2IxMTAwMTkwZTZlNjYiLCJpYXQiOjE3MDk4OTE4OTYsImV4cCI6MTcxMTEwMTQ5Nn0.JD49Aft3WcfWhnvaF0ZZkMyHVYVllezL-qw698SnpII",
            
        },
        body:JSON.stringify(telefono)
    })
    .then(res => res.json())
    .then(res => {

    /*************** REINDIRIZZO-ALLA-PAGINA + ALLERTA-DI-CREAZIONE ***************/
        window.alert("telefono creato")

        location.href = './index.html'

    })

})