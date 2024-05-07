import { Component } from '@angular/core';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.sass'
})
export class SigninComponent {
  email!: string
  password!: string
  constructor(private authSrv: AuthService) { }

  submitLogin(form: NgForm) {
    this.authSrv.login(form.value.credentials).subscribe(res => console.log(res))
  }

}
