class User{

    constructor(_nome,_cognome,_eta,_locazione){
        this.nome = _nome;
        this.cognome = _cognome;
        this.eta = _eta;
        this.locazione = _locazione;

    }


    confronto(nome1,nome2,eta1,eta2){
        if(eta1 > eta2){
            console.log( nome1 + ' è piu grande di ' + nome2 ) 
        }else{
            console.log( nome2 + ' è piu grande di ' + nome1 ) 
        }
    }

}

let x = new User('aldo','moro',12,'ivrea')

let y = new User('stefano','moro',25,'ivrea')


console.log(x)
console.log(y)

x.confronto(x.nome,y.nome,x.eta,y.eta)
