import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './componenti/homepage/homepage.component';
import { CompletatiComponent } from './componenti/completati/completati/completati.component';
import { NocompletatiComponent } from './componenti/nocompletati/nocompletati/nocompletati.component';
import { UserComponent } from './componenti/user/user/user.component';
import { HeaderComponent } from './pagecomponent/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    CompletatiComponent,
    NocompletatiComponent,
    UserComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
