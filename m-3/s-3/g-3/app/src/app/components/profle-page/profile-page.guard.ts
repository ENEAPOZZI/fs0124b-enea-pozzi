import { CanActivateFn } from '@angular/router';



@Injectable({
  providedIn: 'root',
})
export const profilePageGuard: CanActivateFn = (route, state) => {
  export class ProfilePageGuard implements CanActivate {
    isLogged: boolean = false;
    constructor(private authSrv: AuthService, private router: Router) {
      this.authSrv.loggedStatus.subscribe(status => this.isLogged = status);
    }
    canActivate(): boolean {
      if (!this.isLogged) this.router.navigateByUrl("/login")

      return this.isLogged;
    }
};
