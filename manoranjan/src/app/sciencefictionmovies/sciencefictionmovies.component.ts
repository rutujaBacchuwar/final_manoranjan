import { Component, OnInit } from '@angular/core';
import { StandaloneService } from '../standalone.service';
import { StandaloneMedia } from '../standalone-media';

@Component({
  selector: 'app-sciencefictionmovies',
  templateUrl: './sciencefictionmovies.component.html',
  styleUrls: ['./sciencefictionmovies.component.css']
})
export class SciencefictionmoviesComponent implements OnInit {

  movies;
  movies1 = new Array<StandaloneMedia>()
  constructor(private mediaService: StandaloneService) { }

  ngOnInit() {
    this.mediaService.getMovieByGenre("science").subscribe(data => {
      this.movies = data
      this.movies1 = this.movies
      console.log(this.movies1)
    })
  }


}
