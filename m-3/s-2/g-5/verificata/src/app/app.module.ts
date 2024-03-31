import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './pagecomponent/header/header.component';
import { CompletatiComponent } from './pages/completati/completati.component';
import { DacompletareComponent } from './pages/dacompletare/dacompletare.component';
import { UserComponent } from './pages/user/user.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CompletatiComponent,
    DacompletareComponent,
    UserComponent,
    HomepageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
