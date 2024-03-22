import { Component } from '@angular/core';
import { Cars } from '../../models/cars';
import { CarService } from '../../car.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.scss'
})
export class HomePageComponent {


  carsArr:Cars[] = [];
  carsRandom:Cars[] = [];




  constructor(private carsSvc:CarService){}


  ngOnInit(){

    this.carsSvc.AllCar().then(dati => {
      this.carsArr = dati;


      this.carsrandom(2)


    })
  }

  carsrandom(n:number){

    for(let i = 0; i < n; i++){

      let rand = Math.floor(Math.random() * this.carsArr.length)

      this.carsRandom.push( this.carsArr[rand] );

    }



  }




}

