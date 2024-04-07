import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';


import { ServicesService } from '../services.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard {

  constructor(
    private seSvc:ServicesService,
    private router:Router//per i redirect
    ){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): MaybeAsync<GuardResult> {

    if(!this.seSvc.syncIsLoggedIn){
      this.router.navigate(['/login'])
    }

    return this.seSvc.syncIsLoggedIn
  }





  canActivateChild(
    childRoute: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): MaybeAsync<GuardResult> {
    return this.canActivate(childRoute, state)
  }

}
