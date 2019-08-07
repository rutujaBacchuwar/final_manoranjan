import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-secondcard',
  templateUrl: './secondcard.component.html',
  styleUrls: ['./secondcard.component.css']
})
export class SecondcardComponent implements OnInit {
  items: Array<any> = [];
  constructor() {
    this.items = [
      { name: '../../assets/m1.jpeg' },
      { name: '../../assets/m2.jpeg' },
      { name: '../../assets/m3.jpg' },
      { name: '../../assets/caro/3.jpg' },
      { name: '../../assets/m5.jpg' },
      { name: '../../assets/m6.jpg' },
      { name: '../../assets/m7.jpg' },
      { name: '../../assets/m8.jpg' },
      { name: '../../assets/m9.jpg' },
      { name: '../../assets/m10.jpg' },
      { name: '../../assets/m4.jpeg' },
      { name: '../../assets/three idiots.jpeg' },
      { name: '../../assets/dch.jpeg' },
      { name: '../../assets/caro/1.jpg' },
    ];
  }

  ngOnInit() {
  }

}
