import { Component } from '@angular/core';
import { ServicesService } from '../services.service';
import { Users } from '../models/users';

@Component({
  selector: 'app-dash',
  templateUrl: './dash.component.html',
  styleUrl: './dash.component.scss'
})
export class DashComponent {


  constructor(private serSvc:ServicesService){}

  user:Users = {
    name: '',
    cognome: '',
    email: '',
    password: '',
    id:0
  }

  ngOnInit(){
    this.serSvc.user$.subscribe((user => {
      if (user) {

        this.user.id = user.id;
        console.log(user.id)

        this.serSvc.getusersById(user.id).subscribe(
          (userData: Users) => {
            this.user = userData;
            console.log(userData.name);
          }
        );
      }
    }))
  }


}
