import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Userauthen } from '../userauthen';


@Component({
  selector: 'app-myaccount',
  templateUrl: './myaccount.component.html',
  styleUrls: ['./myaccount.component.css']
})
export class MyaccountComponent implements OnInit {

  users: User;
  user = new User();
  private photo:string;
  emailId;
  constructor(private router: Router, private _formBuilder: FormBuilder, private _userService: UserService, private userService: UserService, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.user.emailId = sessionStorage.getItem('email');
    console.log(this.user.emailId)
    this.userService.getById(this.user.emailId).subscribe(data => {
      this.users = data;
      console.log("POST Request is successful ", data);
      console.log("gender:",this.users.gender);
      if(this.users.gender=='male'|| this.users.gender=='Male')
      {
        this.photo='maleDemo.png';
      }
      else
      {
        this.photo='femaleDemo.png';
      }
    },
      error => {
        console.log("Error", error);
      }
    );
  }
  sendEmail(email) {
    this.router.navigateByUrl('/edit/' + email);
  }
}
