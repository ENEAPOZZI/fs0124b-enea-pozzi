import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { AudiComponent } from './pages/cars/audi/audi.component';
import { FiatComponent } from './pages/cars/fiat/fiat.component';
import { FordComponent } from './pages/cars/ford/ford.component';

const routes: Routes = [

  {
    path:'',
    component: HomePageComponent
  },
  {
    path:'Fiat',
    component: FiatComponent
  },
  {
    path:'Ford',
    component: FordComponent
  },
  {
    path:'Audi',
    component: AudiComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
