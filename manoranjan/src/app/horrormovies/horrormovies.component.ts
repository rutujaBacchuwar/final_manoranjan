import { Component, OnInit } from '@angular/core';
import { StandaloneService } from '../standalone.service';
import { StandaloneMedia } from '../standalone-media';

@Component({
  selector: 'app-horrormovies',
  templateUrl: './horrormovies.component.html',
  styleUrls: ['./horrormovies.component.css']
})
export class HorrormoviesComponent implements OnInit {

  movies;
  movies1 = new Array<StandaloneMedia>()
  constructor(private mediaService: StandaloneService) { }

  ngOnInit() {
    this.mediaService.getMovieByGenre("horror").subscribe(data => {
      this.movies = data
      this.movies1 = this.movies
      console.log(this.movies1)
    })
  }

}
