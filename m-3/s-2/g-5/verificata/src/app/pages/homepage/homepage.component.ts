import { UserComponent } from './../user/user.component';
import { UsersService } from '../../service/users.service';
import { TodosService } from './../../service/todos.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.scss'
})
export class HomepageComponent {

  constructor(private todosSvc:TodosService, private userSvc:UsersService){}













  }







