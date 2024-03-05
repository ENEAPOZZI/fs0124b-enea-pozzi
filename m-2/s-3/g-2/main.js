let testo = document.getElementById('testo')
let safe = document.getElementById('safe')
let del = document.getElementById('delete')
let zona = document.getElementById('zona')




safe.addEventListener('click', function(){
    
    let nome = testo.value
    
    let nomeStringa = JSON.stringify(nome)
    

    localStorage.setItem('nome', nomeStringa);

    

    zona.innerHTML= nome

})

console.log(testo.value)


del.addEventListener('click', function(){
    
    
    
    localStorage.removeItem('nome');

    zona.innerHTML=''

    testo.value=''


})