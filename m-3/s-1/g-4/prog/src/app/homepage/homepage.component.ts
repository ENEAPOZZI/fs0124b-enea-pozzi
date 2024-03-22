import { Component } from '@angular/core';
import { Jsoncontent } from '../moduls/jsoncontent';
import { items } from '../moduls/items';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.scss'
})
export class HomepageComponent {

  itemsArr: items[] = [];

  getAllPizza(): Promise<items[]> {
    return fetch('../assets/db.json')
      .then(response => response.json())
      .then((data: Jsoncontent) => data.posts)
      .catch(error => {
        console.error('Error fetching pizza data:', error);
        return []; 
           });
  }

  getActivePizza(): Promise<items[]> {
    return this.getAllPizza()
      .then(posts => posts.filter(p => p.active));
  }

  getInactivePizza(): Promise<items[]> {
    return this.getAllPizza()
      .then(posts => posts.filter(p => !p.active));
  }
}
