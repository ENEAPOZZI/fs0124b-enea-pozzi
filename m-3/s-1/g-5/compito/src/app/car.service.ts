import { Injectable } from '@angular/core';
import { Cars } from './models/cars';

@Injectable({
  providedIn: 'root'
})
export class CarService {

 AllCar():Promise<Cars[]>{

  return fetch('../assets/db.json')
  .then(dati=> dati.json())
  .then((dati:Cars[])=>dati)

 }

 CarsAudi():Promise<Cars[]>{
  return this.AllCar()
  .then(dati => dati.filter(m => m.brand ==='Audi'))
 }

 CarsFiat():Promise<Cars[]>{
  return this.AllCar()
  .then(dati => dati.filter(m => m.brand ==='Fiat'))
 }

 CarsFord():Promise<Cars[]>{
  return this.AllCar()
  .then(dati => dati.filter(m => m.brand ==='Ford'))
 }




}
