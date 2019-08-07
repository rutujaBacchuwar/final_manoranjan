import { Component, OnInit } from '@angular/core';
import { StandaloneService } from '../standalone.service';
import { StandaloneMedia } from '../standalone-media';

@Component({
  selector: 'app-thrillermovies',
  templateUrl: './thrillermovies.component.html',
  styleUrls: ['./thrillermovies.component.css']
})
export class ThrillermoviesComponent implements OnInit {

  movies;
  movies1 = new Array<StandaloneMedia>()
  constructor(private mediaService: StandaloneService) { }

  ngOnInit() {
    this.mediaService.getMovieByGenre("kids").subscribe(data => {
      this.movies = data
      this.movies1 = this.movies
      console.log(this.movies1)
    })
  }


}
