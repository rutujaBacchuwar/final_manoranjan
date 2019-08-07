import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-datacardepisodic',
  templateUrl: './datacardepisodic.component.html',
  styleUrls: ['./datacardepisodic.component.css']
})
export class DatacardepisodicComponent implements OnInit {

  @Input() public heading;

  @Input() public list;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  sendDetails(serial) {
    let x = JSON.stringify(serial)
    sessionStorage.setItem("serial", x);
    this.router.navigateByUrl("/image");
  }

}
