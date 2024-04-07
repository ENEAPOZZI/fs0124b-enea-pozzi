import { ServicesService } from '../services.service';
import { Users } from './../models/users';
import { Component } from '@angular/core';

@Component({
  selector: 'app-utenti',
  templateUrl: './utenti.component.html',
  styleUrl: './utenti.component.scss'
})
export class UtentiComponent {



  Users: Users[] = [];




  constructor(private serSvc: ServicesService) { }



  ngOnInit(): void {
    this.getusers();
  }

  getusers(): void {
    this.serSvc.getusers().subscribe(data => {
      this.Users = data;

      console.log(data)


    });
  }


}
