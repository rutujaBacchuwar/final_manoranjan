import { Component, OnInit,Input } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-uploadedvideos',
  templateUrl: './uploadedvideos.component.html',
  styleUrls: ['./uploadedvideos.component.css']
})
export class UploadedvideosComponent implements OnInit {


  @Input() public heading;

  @Input() public list;

  items: Array<any> = [];

  constructor(private userService:UserService) {
  }
  ngOnInit() {
  }

}
