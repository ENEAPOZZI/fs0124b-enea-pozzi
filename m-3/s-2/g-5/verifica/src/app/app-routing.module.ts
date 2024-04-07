import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './componenti/user/user/user.component';
import { NocompletatiComponent } from './componenti/nocompletati/nocompletati/nocompletati.component';
import { CompletatiComponent } from './componenti/completati/completati/completati.component';
import { HomepageComponent } from './componenti/homepage/homepage/homepage.component';

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
    path: 'fare',
    component: NocompletatiComponent,
  },
  {
    path: "user",
    component: UserComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
