import { Component } from '@angular/core';
import { UsersService } from '../../service/users.service';
import { TodosService } from '../../service/todos.service';

@Component({
  selector: 'app-completati',
  templateUrl: './completati.component.html',
  styleUrl: './completati.component.scss'
})
export class CompletatiComponent {

  constructor(private todosSvc:TodosService){}



  nuovoArr = this.todosSvc.getcompletiArrMisto()





}
