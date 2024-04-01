import { Component } from '@angular/core';
import { TodosService } from '../../service/todos.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.scss'
})
export class UserComponent {
index: any;

constructor(private todosSvc:TodosService){}


nuovoArr= this.todosSvc.getAllArrMisto()



}
