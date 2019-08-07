import { Component, OnInit } from '@angular/core';
import { StandaloneService } from '../standalone.service';
import { StandaloneMedia } from '../standalone-media';

@Component({
  selector: 'app-comedymovies',
  templateUrl: './comedymovies.component.html',
  styleUrls: ['./comedymovies.component.css']
})
export class ComedymoviesComponent implements OnInit {

  movies;
  movies1 = new Array<StandaloneMedia>()
  constructor(private mediaService: StandaloneService) { }

  ngOnInit() {
    this.mediaService.getMovieByGenre("comedy").subscribe(data => {
      this.movies = data
      this.movies1 = this.movies
    })
  }


}
