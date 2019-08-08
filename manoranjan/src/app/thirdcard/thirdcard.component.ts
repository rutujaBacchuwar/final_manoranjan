import { Component, OnInit } from '@angular/core';
import { RecommendationService } from '../recommendation.service';
import { StandaloneService } from '../standalone.service';

@Component({
  selector: 'app-thirdcard',
  templateUrl: './thirdcard.component.html',
  styleUrls: ['./thirdcard.component.css']
})
export class ThirdcardComponent implements OnInit {

  id;
  items: Array<any> = [];
  constructor(private recommendation:RecommendationService, private standAlone: StandaloneService) {

  }

  ngOnInit() {

    this.id=sessionStorage.getItem('email');
    console.log(this.id);
    let allTitles = []

    this.recommendation.getRecInterestMovie(this.id).subscribe(data=>{
      // this.items=data;
      console.log(this.items);
      allTitles = data.map(e => {
        return e.mediaTitle
      })
      console.log(allTitles)
      allTitles.map(e => {
        this.standAlone.getMediaById(e).subscribe(media => {
            this.items.push(media);
        })
      })
    })
  }

}
