import { Login } from './models/login';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';




const routes: Routes = [


 { path: 'film', loadChildren: () => import('./film/film.module').then(m => m.FilmModule), },

 { path: 'utenti', loadChildren: () => import('./utenti/utenti.module').then(m => m.UtentiModule),},

  { path: 'register', loadChildren: () => import('./rigister/rigister.module').then(m => m.RigisterModule), },

  { path: '', loadChildren: () => import('./login/login.module').then(m => m.LoginModule) },

 { path: 'dash', loadChildren: () => import('./dash/dash.module').then(m => m.DashModule), }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
