import { Component } from '@angular/core';

@Component({
  selector: 'app-profle-page',
  templateUrl: './profle-page.component.html',
  styleUrl: './profle-page.component.scss'
})
export class ProflePageComponent implements OnInit {
  user:SignUp = {} as SignUp
  constructor(private authSrv: AuthService) { }

  ngOnInit(): void {
    this.authSrv.currentLoggedUsed()?.subscribe(user => this.user = user[0])
  }

  logout() {
    this.authSrv.logout()
  }

}
