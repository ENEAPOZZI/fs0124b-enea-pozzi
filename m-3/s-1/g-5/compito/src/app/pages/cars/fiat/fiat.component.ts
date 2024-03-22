import { Component } from '@angular/core';
import { Cars } from '../../../models/cars';
import { CarService } from '../../../car.service';

@Component({
  selector: 'app-fiat',
  templateUrl: './fiat.component.html',
  styleUrl: './fiat.component.scss'
})
export class FiatComponent {


  fiatcarsArr:Cars[] = [];




  constructor(private carsSvc:CarService){}


  ngOnInit(){

    this.carsSvc.CarsFiat().then(dati => {
      this.fiatcarsArr = dati;



    })
  }

}
