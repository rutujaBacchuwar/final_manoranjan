import { Component, OnInit } from '@angular/core';
import { Episodic } from '../episodic';
import { EpisodicService } from '../episodic.service';

@Component({
  selector: 'app-gujarathiserials',
  templateUrl: './gujarathiserials.component.html',
  styleUrls: ['./gujarathiserials.component.css']
})
export class GujarathiserialsComponent implements OnInit {

  serials;
  serials1 = new Array<Episodic>()
  constructor(private mediaService: EpisodicService) { }

  ngOnInit() {
    this.mediaService.getShowsByLanguage("Gujarathi").subscribe(data => {
      this.serials = data
      this.serials1 = this.serials
      console.log(this.serials1)
    })
  }

}
