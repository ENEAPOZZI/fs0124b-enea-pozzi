import { Component } from '@angular/core';
import { items } from './moduls/items';
import { Jsoncontent } from './moduls/jsoncontent';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

  itemsArr:items [] = [];


  ngOnInit(){

    fetch('../assets/db.json')
    .then(items => items.json())
    .then((items:Jsoncontent) => this.itemsArr = items.posts)

  }




}


