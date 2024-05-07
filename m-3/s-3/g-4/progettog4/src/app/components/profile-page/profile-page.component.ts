import { Component } from '@angular/core';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrl: './profile-page.component.sass'
})
export class ProfilePageComponent {

  user:SignUp = {} as SignUp
  constructor(private authSrv: AuthService) { }

  ngOnInit(): void {
    this.authSrv.currentLoggedUsed()?.subscribe(user => this.user = user[0])
  }

  logout() {
    this.authSrv.logout()
  }

}
