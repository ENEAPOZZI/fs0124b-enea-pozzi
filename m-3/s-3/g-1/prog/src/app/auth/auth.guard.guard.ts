import { CanActivateFn } from '@angular/router';




@Injectable({
  providedIn: 'root'
})
export const authGuardGuard: CanActivateFn = (route, state) => {
  CanActivate, CanActivateChild {
    constructor(private authSrv:AuthService, @Inject(Router) private router:Router){}
    canActivate(
      route: ActivatedRouteSnapshot,
      state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      return this.authSrv.isAuthenticated().then(isloggedin=>{
        if (isloggedin) {
          return true
        }
        alert('Per visualizzare questa risorsa devi essere loggato!')
        return this.router.createUrlTree(['/'])
      });
    }
    canActivateChild(
      childRoute: ActivatedRouteSnapshot,
      state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      return this.canActivate(childRoute,state);
    }s
};
