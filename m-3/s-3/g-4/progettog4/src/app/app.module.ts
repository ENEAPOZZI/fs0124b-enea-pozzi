import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PipesPipe } from './pipes/pipes.pipe';
import { AllUsersComponent } from './components/all-users/all-users.component';
import { ProfilePageComponent } from './components/profile-page/profile-page.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './component/signup/signup.component';
import { AuthserviceComponent } from './interfaces/authservice/authservice.component';

@NgModule({
  declarations: [
    AppComponent,
    PipesPipe,
    AllUsersComponent,
    ProfilePageComponent,
    SigninComponent,
    SignupComponent,
    AuthserviceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
