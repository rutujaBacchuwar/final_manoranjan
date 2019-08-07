import { Component, OnInit } from '@angular/core';
import { StandaloneService } from '../standalone.service';
import { StandaloneMedia } from '../standalone-media';

@Component({
  selector: 'app-actionmovies',
  templateUrl: './actionmovies.component.html',
  styleUrls: ['./actionmovies.component.css']
})
export class ActionmoviesComponent implements OnInit {

  movies;
  movies1 = new Array<StandaloneMedia>()
  constructor(private mediaService: StandaloneService) { }

  ngOnInit() {
    this.mediaService.getMovieByGenre("action").subscribe(data => {
      this.movies = data
      this.movies1 = this.movies
    })
  }
}