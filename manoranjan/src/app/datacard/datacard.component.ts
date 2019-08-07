import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-datacard',
  templateUrl: './datacard.component.html',
  styleUrls: ['./datacard.component.css']
})
export class DatacardComponent implements OnInit {


  @Input() public heading;

  @Input() public list;

  constructor() {
  }

  ngOnInit() {
  }

}
