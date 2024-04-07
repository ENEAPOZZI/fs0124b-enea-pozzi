import { Injectable } from '@angular/core';
import { Users } from './models/users';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, Observable, map, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from '../environments/environment.development';
import { Login } from './models/login';
import { Films } from './models/films';


type AccessData = {
  accessToken:string,
  user:Users
}

@Injectable({
  providedIn: 'root'
})
export class ServicesService {


  jwtHelper:JwtHelperService = new JwtHelperService()

  authSubject = new BehaviorSubject<Users|null>(null);

  syncIsLoggedIn:boolean = false;


 user$ = this.authSubject.asObservable()

 isLoggedIn$ = this.user$.pipe(
   map(user => !!user),
   tap(user =>  {
     console.log('utente loggato', user);
     this.syncIsLoggedIn = user;
   })
   )
  currentUser: any;

    constructor(
      private http:HttpClient,
      private router:Router
      ) {


      }

      registerUrl:string = environment.registerUrl
      loginUrl:string = environment.loginUrl

      register(newUser:Partial<Users>):Observable<AccessData>{
        return this.http.post<AccessData>(this.registerUrl,newUser)
      }

      login(loginData:Login):Observable<AccessData>{
        return this.http.post<AccessData>(this.loginUrl,loginData)
        .pipe(tap(data => {

          this.authSubject.next(data.user)
          localStorage.setItem('accessData', JSON.stringify(data))

          this.autoLogout(data.accessToken)

        }))
      }



    logout(){

      this.authSubject.next(null)
      localStorage.removeItem('accessData')

      this.router.navigate(['/register'])
    }


  getAccessToken():string{
    const userJson = localStorage.getItem('accessData')
    if(!userJson) return '';

    const accessData:AccessData = JSON.parse(userJson)
    if(this.jwtHelper.isTokenExpired(accessData.accessToken)) return '';

    return accessData.accessToken
  }


  autoLogout(jwt:string){
    const expDate = this.jwtHelper.getTokenExpirationDate(jwt) as Date;
    const expMs = expDate.getTime() - new Date().getTime();


    setTimeout(()=>{
      this.logout()
    },expMs)
  }


  restoreUser(){

    const userJson = localStorage.getItem('accessData')
    if(!userJson) return;

    const accessData:AccessData = JSON.parse(userJson)
    if(this.jwtHelper.isTokenExpired(accessData.accessToken)) return;

    this.authSubject.next(accessData.user)
    this.autoLogout(accessData.accessToken)

  }

  urlfilms:string = environment.films


  getMovies(){
    return this.http.get<Films[]>(this.urlfilms);
   }


   urlutenti:string = environment.registerUrl


   getusers(){
     return this.http.get<Users[]>(this.urlutenti);
    }


    getusersById(id:number){
      return this.http.get<Users>(this.registerUrl+'/'+id)
    }


}
