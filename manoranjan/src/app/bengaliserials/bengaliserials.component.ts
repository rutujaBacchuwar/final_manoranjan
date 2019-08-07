import { Component, OnInit } from '@angular/core';
import { Episodic } from '../episodic';
import { EpisodicService } from '../episodic.service';

@Component({
  selector: 'app-bengaliserials',
  templateUrl: './bengaliserials.component.html',
  styleUrls: ['./bengaliserials.component.css']
})
export class BengaliserialsComponent implements OnInit {

  serials;
  serials1 = new Array<Episodic>()
  constructor(private mediaService: EpisodicService) { }

  ngOnInit() {
    this.mediaService.getShowsByLanguage("Bengali").subscribe(data => {
      this.serials = data
      this.serials1 = this.serials
    })
  }
}
