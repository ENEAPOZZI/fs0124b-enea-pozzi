import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { AudiComponent } from './pages/cars/audi/audi.component';
import { FiatComponent } from './pages/cars/fiat/fiat.component';
import { FordComponent } from './pages/cars/ford/ford.component';
import { HeaderComponent } from './pagescomponent/header/header.component';
import { FooterComponent } from './pagescomponent/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AudiComponent,
    FiatComponent,
    FordComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
