let header = document.getElementById('header')
let bottone = document.getElementById('bottone')

/*
header.style.backgroundColor='#fff'
bottone.style.backgroundColor='red'
*/

window.addEventListener('scroll',function(){
    let nScrol= window.scrollY

    
    if(nScrol >= 400){
        header.style.backgroundColor='#fff'
        bottone.style.backgroundColor='#1a8917'
    }else {
        header.style.backgroundColor=''
        bottone.style.backgroundColor=''
    }
})


