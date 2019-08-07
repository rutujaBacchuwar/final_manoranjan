import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-thirdcard',
  templateUrl: './thirdcard.component.html',
  styleUrls: ['./thirdcard.component.css']
})
export class ThirdcardComponent implements OnInit {

  items: Array<any> = [];
  constructor() {
    this.items = [
      { name: '../../assets/tv1.webp' },
      { name: '../../assets/tv2.webp' },
      { name: '../../assets/tv3.webp' },
      { name: '../../assets/tv4.webp' },
      { name: '../../assets/tv5.webp' },
      { name: '../../assets/luka-chupi.jpg' },
      { name: '../../assets/rab-ne-bnad- jodi.jpg' },
      { name: '../../assets/ddlj.jpg' },
      { name: '../../assets/chennai-express.jpg' },
    ];
  }

  ngOnInit() {
  }

}
