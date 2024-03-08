






const btnSalva =  document.querySelector('#save')

btnSalva.addEventListener('click',function(e){
    e.preventDefault()

    let name = document.querySelector('#nome').value
    let brand = document.querySelector('#modello').value
    let price = document.querySelector('#prezzo').value
    let imageUrl = document.querySelector('#img').value
    let description = document.querySelector('#textarea').value

    let telefono = {
        name,
        brand,
        price,
        imageUrl,
        description,
    }

   
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

        window.alert("telefono creato")

        location.href = './index.html'

    })

})