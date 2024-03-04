
let posto = document.getElementById('posto')

posto.innerText.x


let invia = document.getElementById('invia')

invia.addEventListener('click',function(e){
    e.preventDefault();

    let _animale = document.form.animale.value;
    let _padrone = document.form.padrone.value;
    let _tipo = document.form.tipo.value;
    let _razza = document.form.razza.value;

    let pet = new Pet (_animale,_padrone,_tipo, _razza)
    

    
    console.log(pet)
    pet.same()


})





class Pet {

    constructor(_animale,_padrone,_tipo,_razza){

        this.animale=_animale;
        this.padrone=_padrone;
        this.tipo=_tipo;
        this.razza=_razza;
    }


    same(){
        let x = [];

        x.push.pet._padrone

        x.forEach(i => {
            if(i === i){
                console.log(true)
            }
        });
    }
}



function ciao (...animali){
    let x = [...animali]
    return x 
}

