import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-like-card',
  templateUrl: './like-card.component.html',
  styleUrls: ['./like-card.component.css']
})
export class LikeCardComponent implements OnInit {

  @Input() public list;
  @Input() public title;
  items: Array<any> = [];
  constructor() {
    this.items = [
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_hs_1x/sources/r1/cms/prod/4388/524388-h' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_hs_1x/sources/r1/cms/prod/2092/522092-h' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_hs_1x/sources/r1/cms/prod/6994/516994-h' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_hs_1x/sources/r1/cms/prod/1269/521269-h' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_hs_1x/sources/r1/cms/prod/5294/515294-h' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_hs_1x/sources/r1/cms/prod/9068/519068-h' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_hs_1x/sources/r1/cms/prod/9852/519852-h' },
      { name: 'https://img1.hotstarext.com/image/upload/f_auto,t_web_hs_1x/sources/r1/cms/prod/6183/516183-h' },
    ];
  }

  ngOnInit() {
  }

}
