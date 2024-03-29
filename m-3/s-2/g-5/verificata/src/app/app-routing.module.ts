import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { CompletatiComponent } from './pages/completati/completati.component';
import { DacompletareComponent } from './pages/dacompletare/dacompletare.component';
import { UserComponent } from './pages/user/user.component';

const routes: Routes = [

  {
    path: '',
    component: HomepageComponent,
  },
  {
    path: 'completati',
    component: CompletatiComponent,
  },
  {
    path: 'dafare',
    component: DacompletareComponent,
  },
  {
    path: "users",
    component: UserComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
