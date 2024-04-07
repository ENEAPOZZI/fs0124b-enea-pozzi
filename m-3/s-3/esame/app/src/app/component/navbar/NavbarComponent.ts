import { Component } from '@angular/core';
import { ServicesService } from '../../services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {
  title = 'bootstrap';

  isCollapsed = false;

  isUserLoggedIn:boolean = true;







  constructor(private authSvc:ServicesService,private router: Router){}

  ngOnInit(){

    this.authSvc.isLoggedIn$.subscribe(data => {
      this.isUserLoggedIn = data;
      console.log(data);
    });

  }

  logout(){
    this.authSvc.logout()
  }

  navigateToDash(userId: number): void {
    this.router.navigate(['/dash', userId]);
  }


}
