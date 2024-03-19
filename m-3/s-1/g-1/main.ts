
interface Smartphone {
    
    credito: number
    numeroChiamate: number



    get getNumeroChiamate(): number
    azzeraChiamate(): void

    ricarica(ammontare:number): void
    chiamata(minutiDurata: number): void
    get numero404(): number

}


class User implements Smartphone {
    name: string
    lastName: string
    credito: number = 0
    numeroChiamate: number = 0
    
    constructor(name: string, lastName: string) {
        this.name = name
        this.lastName = lastName
    }
    ricarica(ammontare: number): void {
        this.credito += ammontare
    }
    chiamata(minutiDurata: number): void {
       
        this.credito -= (minutiDurata * 0.20)
        this.numeroChiamate+= 1
    }
    azzeraChiamate(): void {
        this.numeroChiamate = 0
    }
    get numero404() {
        return this.credito
    }
    get getNumeroChiamate() {
        return this.numeroChiamate
    }
}

const me = new User("lidia", "kovac")
me.ricarica(10)
me.chiamata(1)
me.chiamata(1)
me.chiamata(2)
me.chiamata(6)
console.log(me.numero404)
console.log(me.getNumeroChiamate)
me.azzeraChiamate()