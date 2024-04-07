
import { Component } from '@angular/core';
import { Films } from '../models/films';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { ServicesService } from '../services.service';



@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrl: './film.component.scss'
})
export class FilmComponent {


  Films: Films[] = [];




  constructor(private serSvc: ServicesService) { }



  ngOnInit(): void {
    this.getMovies();
  }

  getMovies(): void {
    this.serSvc.getMovies().subscribe(data => {
      this.Films = data;



    });
  }


}
