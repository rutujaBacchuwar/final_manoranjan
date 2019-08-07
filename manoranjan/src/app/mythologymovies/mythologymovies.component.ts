import { Component, OnInit } from '@angular/core';
import { StandaloneService } from '../standalone.service';
import { StandaloneMedia } from '../standalone-media';

@Component({
  selector: 'app-mythologymovies',
  templateUrl: './mythologymovies.component.html',
  styleUrls: ['./mythologymovies.component.css']
})
export class MythologymoviesComponent implements OnInit {

  movies;
  movies1 = new Array<StandaloneMedia>()
  constructor(private mediaService: StandaloneService) { }

  ngOnInit() {
    this.mediaService.getMovieByGenre("mythology").subscribe(data => {
      this.movies = data
      this.movies1 = this.movies
      console.log(this.movies1)
    })
  }


}
