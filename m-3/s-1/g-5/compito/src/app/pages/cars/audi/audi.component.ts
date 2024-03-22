import { Component } from '@angular/core';
import { Cars } from '../../../models/cars';
import { CarService } from '../../../car.service';

@Component({
  selector: 'app-audi',
  templateUrl: './audi.component.html',
  styleUrl: './audi.component.scss'
})
export class AudiComponent {


  audicarsArr:Cars[] = [];




  constructor(private carsSvc:CarService){}


  ngOnInit(){

    this.carsSvc.CarsAudi().then(dati => {
      this.audicarsArr = dati;



    })
  }


 }

