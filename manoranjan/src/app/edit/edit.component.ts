import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  users: User;
  user = new User();
  emailId;
  constructor(private activatedRoute: ActivatedRoute, private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.emailId = params.get('email');
      console.log(this.emailId);
    })
  }

  save(name, email, age, mobile) {
    this.user.name = name
    this.user.emailId = email
    this.user.age = age
    this.user.mobileNo = mobile
    console.log(this.emailId);
    this.userService.updateUser(this.emailId, this.user).subscribe(data => {
      console.log("update Request is successful ", data);
    },
      error => { console.log("Error", error); })
    this.router.navigateByUrl('/myaccount/');

  }
}
