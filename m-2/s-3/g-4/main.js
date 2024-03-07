let hey = 'Ult6BT3cN7RSBvAUwdf4gxlOQorgXfA3iwqfJmaV4KMtlnHbfrB3ce80'




async function chiamata(query){

    let key = 'Ult6BT3cN7RSBvAUwdf4gxlOQorgXfA3iwqfJmaV4KMtlnHbfrB3ce80'
    
    return await fetch(`https://api.pexels.com/v1/search?query=${query}`, {
        method: 'GET',
        headers: {
            Authorization: key
        }
    }).then(dati => dati.json())
}







let btn = document.getElementById('load')


btn.addEventListener('click', function(){


    chiamata('cat').then(items => {

        items.photos.forEach(el, index => {
            console.log(el.url)

            let img = document.querySelectorAll('.card-img-top')

            img[index].src=el.src.medium
        
        });
    
       
      
      })
      

})
