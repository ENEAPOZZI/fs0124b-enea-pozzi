


fetch('https://striveschool-api.herokuapp.com/books')
.then(response => response.json())
.then(dati =>{



    let row = document.getElementById('row')


      
    for(let user of dati){

        let card = document.createElement('div')
        card.classList.add('card')
        card.setAttribute('style','width: 18rem;')

        let img = document.createElement('img')
        img.classList.add('card-img-top','h-50')
       
        img.src= user.img
        
        

        

        let cartBody = document.createElement('div')
        cartBody.classList.add('card-body')
        
        let nomeLibro = user.title
        let titoloLibro = document.createElement('h5')
        titoloLibro.innerText = nomeLibro

        cartBody.append(titoloLibro)


        let prezzo = user.price
        let prezzoLibro = document.createElement('p')

        prezzoLibro.innerText = prezzo + '$'

        cartBody.append(prezzoLibro)


        let btn = document.createElement('div')
        
        
        btn.classList.add('btn')
        btn.classList.add('btn-primary')
        btn.innerText ='compra'

        let carello = document.getElementById('carello')

        btn.addEventListener('click', function(){

            let div = document.createElement('div')
        
            
            div.innerText = nomeLibro


            let deleteBtn = document.createElement('div')
            deleteBtn.classList.add('btn')
            deleteBtn.classList.add('btn-primary')
            deleteBtn.innerText= 'elimina'
            div.append(deleteBtn)

            

            

            carello.append(div)

            deleteBtn.addEventListener('click', function(){

                div.classList.add('d-none')
                
            })


        })
        card.append(img)
        card.append(cartBody)
        card.append(btn)

        let col = document.createElement('div')
        col.classList.add('col-4')

       





        col.append(card)

        row.append(col)



    }

})