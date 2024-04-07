import { Component } from '@angular/core';
import { Users } from '../models/users';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rigister',
  templateUrl: './rigister.component.html',
  styleUrl: './rigister.component.scss'
})
export class RigisterComponent {

  registerData:Partial<Users> = {  }

  constructor(
    private authSvc:ServicesService,
    private router:Router
    ){}

  signUp(){
    this.authSvc.register(this.registerData)
    .subscribe(data => {

      this.router.navigate(['/film'])

    })
  }


}
