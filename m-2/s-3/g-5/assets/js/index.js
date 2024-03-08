
 
fetch(`https://striveschool-api.herokuapp.com/api/product/`,{
    method:'GET',
    headers:{
        "Authorization":"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTEzODJkN2IxMTAwMTkwZTZlNjYiLCJpYXQiOjE3MDk4OTE4OTYsImV4cCI6MTcxMTEwMTQ5Nn0.JD49Aft3WcfWhnvaF0ZZkMyHVYVllezL-qw698SnpII",
    },
    
})
.then(res => res.json())
.then(telefoni => {


    for(let telefono of telefoni){

        let card = generaClone()
    


        let id = card.querySelector('.id')
        let nome = card.querySelector('#nome')
        let modello = card.querySelector('#modello')
        let descrizione = card.querySelector('#descrizione')
        let prezzo = card.querySelector('#prezzo')
        let img = card.querySelector('#img')
        


        let modificaBtn = card.querySelector('#modifica')
        let scopriBtn = card.querySelector('#scopri')
        let eliminaBtn = card.querySelector('#elimina')
        

        
        console.log(telefono._id) 
        img.src = telefono.imageUrl
        nome.innerText = telefono.name
        modello.innerText = telefono.brand
        prezzo.innerText = telefono.price
        descrizione.innerText = telefono.description

        modificaBtn.href = `edit.html?id=${telefono.id}`
        scopriBtn.href = `dettagli.html?id=${telefono.id}`

        scopriBtn.addEventListener('click',function(){

            location.href = '../dettagli.html'
            
        })
        
        eliminaBtn.addEventListener('click',function(){

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
            
        })

   
        document.querySelector('#prodotti').append(card)

    }
   
  

})







function generaClone(){
    
    let template = document.querySelector('#template')
    let clone = template.content.cloneNode(true)

    return clone;
}