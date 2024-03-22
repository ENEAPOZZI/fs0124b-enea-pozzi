import { Component } from '@angular/core';
import { Cars } from '../../../models/cars';
import { CarService } from '../../../car.service';

@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrl: './ford.component.scss'
})
export class FordComponent {



  fordcarsArr:Cars[] = [];




  constructor(private carsSvc:CarService){}


  ngOnInit(){

    this.carsSvc.CarsFord().then(dati => {
      this.fordcarsArr = dati;



    })
  }


}
