import { Component, OnInit,Input } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-uploaded',
  templateUrl: './uploaded.component.html',
  styleUrls: ['./uploaded.component.css']
})
export class UploadedComponent implements OnInit {

  @Input() public heading;

  @Input() public list;

  items: Array<any> = [];

  constructor(private userService:UserService) {
  }
  ngOnInit() {}

}
