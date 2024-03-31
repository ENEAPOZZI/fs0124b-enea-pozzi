import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

  collasato: boolean = true;

  fallocollasato() {
    this.collasato = !this.collasato;
  }
}
