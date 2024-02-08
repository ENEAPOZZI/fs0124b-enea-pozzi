    
    
    
    let tabella = document.getElementById('tabella')
   



    function creaNumeriTabella(){

        
        for(let i = 1; i < 77 ; i++){
    
             
            let divPerNumeri = document.createElement('div')

            
            divPerNumeri.append(i)
            divPerNumeri.classList.add('numeri')

            tabella.append(divPerNumeri)
           
        }



        


    }

    creaNumeriTabella()


    let bottone = document.getElementById('bottone')


    bottone.addEventListener('click', function(){

        let numeroBottone = Math.floor(Math.random()*77)

        let numeroTabella = document.querySelectorAll('.numeri')
        

        console.log(parseInt(numeroTabella) )
       
        for(let i = 0 ; i < numeroTabella; i++){

            console.log(numeroTabella.childNodes )
        }



    })


   
