import { Component, OnInit } from '@angular/core';
import { Episodic } from '../episodic';
import { Router } from '@angular/router';
import { EpisodicService } from '../episodic.service';

@Component({
  selector: 'app-hindiserials',
  templateUrl: './hindiserials.component.html',
  styleUrls: ['./hindiserials.component.css']
})
export class HindiserialsComponent implements OnInit {

  serials;
  serials1 = new Array<Episodic>()
  constructor(private mediaService: EpisodicService, private router: Router) { }

  ngOnInit() {
    this.mediaService.getShowsByLanguage("Hindi").subscribe(data => {
      this.serials = data
      this.serials1 = this.serials
      console.log(this.serials1)
    })
  }

  sendDetails(serial) {
    let x = JSON.stringify(serial)
    sessionStorage.setItem("serial", x);
    console.log(serial.episodicTitle)
    this.router.navigateByUrl("/image");
  }
}
