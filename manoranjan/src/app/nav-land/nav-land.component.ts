import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-land',
  templateUrl: './nav-land.component.html',
  styleUrls: ['./nav-land.component.css']
})
export class NavLandComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    sessionStorage.clear();
  }

}
