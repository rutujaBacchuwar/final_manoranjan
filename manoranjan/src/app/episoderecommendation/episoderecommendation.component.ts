import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-episoderecommendation',
  templateUrl: './episoderecommendation.component.html',
  styleUrls: ['./episoderecommendation.component.css']
})
export class EpisoderecommendationComponent implements OnInit {

  items: Array<any> = [];
  constructor() {
    this.items = [
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1x/sources/r1/cms/prod/1883/311883-v' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_3x/sources/r1/cms/prod/4969/434969-v' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1x/sources/r1/cms/prod/1145/341145-v' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1x/sources/r1/cms/prod/5448/515448-v' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1x/sources/r1/cms/prod/2482/332482-v' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1x/sources/r1/cms/prod/4524/494524-v' }

    ];
  }

  ngOnInit() {
  }

}
