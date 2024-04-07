import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from '../models/users';
import { ServicesService } from '../services.service';
import { Login } from '../models/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {


  loginData:Login = {
    email: '',
    password: ''
  }


  constructor(
    private authSvc:ServicesService,
    private router:Router
    ){}

    signIn(){

      this.authSvc.login(this.loginData)
      .subscribe(data => {
        this.router.navigate(['/film'])
      })

    }

}
