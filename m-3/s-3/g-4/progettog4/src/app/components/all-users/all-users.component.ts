import { Component } from '@angular/core';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrl: './all-users.component.sass'
})
export class AllUsersComponent {
  users!: SignUp[]
  constructor(private userSrv: AuthService) {
    this.userSrv.userList.subscribe(_users => {
      this.users = _users
    })
  }

}
