import { TodosService } from './../../service/todos.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-dacompletare',
  templateUrl: './dacompletare.component.html',
  styleUrl: './dacompletare.component.scss'
})
export class DacompletareComponent {


  constructor(private todosSvc:TodosService){}


  nuovoArr = this.todosSvc.getnocompletiArrMisto()




}
