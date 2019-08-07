import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-firstcard',
  templateUrl: './firstcard.component.html',
  styleUrls: ['./firstcard.component.css']
})
export class FirstcardComponent implements OnInit {

  items: Array<any> = [];

  constructor() {
    this.items = [
      { name: '../../assets/caro/5.jpg' },
      { name: '../../assets/mov3.webp' },
      { name: '../../assets/caro/2.jpg' },
      { name: '../../assets/caro/1.jpg' },
      { name: '../../assets/mov5.webp' },
      { name: '../../assets/mov1.webp' },
      { name: '../../assets/caro/4.jpg' },
      { name: '../../assets/caro/3.jpg' },
      { name: '../../assets/dch.jpeg' },
      { name: '../../assets/kahani.jpeg' },
      { name: '../../assets/mov4.webp' },
      { name: '../../assets/three idiots.jpeg' },
      { name: '../../assets/m1.jpeg' },
      { name: '../../assets/lagan.jpeg' },
      { name: '../../assets/ddlj.jpeg' },
    ];
  }
  ngOnInit() {
  }
}
