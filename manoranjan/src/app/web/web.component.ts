import { Component, OnInit } from '@angular/core';
import { Episodic } from '../episodic';
import { Router } from '@angular/router';
import { EpisodicService } from '../episodic.service';

@Component({
  selector: 'app-web',
  templateUrl: './web.component.html',
  styleUrls: ['./web.component.css']
})
export class WebComponent implements OnInit {

  series;
  series1 = new Array<Episodic>()

  constructor(private mediaService: EpisodicService, private router: Router) { }

  ngOnInit() {
    this.mediaService.getEpisodic("Web Series").subscribe(data => {
      this.series = data;
      this.series1 = this.series
      console.log(this.series1)
    })
  }
  sendDetails(serial) {
    let x = JSON.stringify(serial)
    sessionStorage.setItem("serial", x);
    console.log(serial.episodicTitle)
    this.router.navigateByUrl("/image");
  }
}
