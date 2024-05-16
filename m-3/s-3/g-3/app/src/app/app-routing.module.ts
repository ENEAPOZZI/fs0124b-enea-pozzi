import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  {
    path: "login",
    // component: SigninComponent,
    loadChildren: () => import("./components/signin/signin.module").then(m => m.SigninModule)
    , canActivate: [SigninGuard]
  },
  {
    path: "signup",
    // component: SignupComponent,
    loadChildren: () => import("./components/signup/signup.module").then(m => m.SignupModule)
  },
  {
    path: "",
    component: ProfilePageComponent,
    canActivate: [ProfilePageGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
