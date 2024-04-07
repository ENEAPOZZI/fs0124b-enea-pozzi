import { Component } from '@angular/core';
import { ServicesService } from '../services.service';
import { ActivatedRoute } from '@angular/router';
import { Users } from '../models/users';

@Component({
  selector: 'app-dash',
  templateUrl: './dash.component.html',
  styleUrl: './dash.component.scss'
})
export class DashComponent {


  constructor(private serSvc:ServicesService,    private route: ActivatedRoute,){}

  user:Users = {
    name: '',
    cognome: '',
    email: '',
    password: '',
    id:0
  }
  ngOnInit(): void {
    this.route.params.subscribe((params: any) => {
      const id = params.id;
      if (id) {
        this.serSvc.getusersById(id).subscribe(
          (user: Users) => {
            this.user = user;
            console.log(user.name);
          },

        );
      }
    });

}

}
