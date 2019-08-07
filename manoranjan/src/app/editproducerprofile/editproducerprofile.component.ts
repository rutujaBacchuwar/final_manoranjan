import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Producer } from '../producer';
import { Router, ActivatedRoute } from '@angular/router';

import { Overlay } from '@angular/cdk/overlay';

@Component({
  selector: 'app-editproducerprofile',
  templateUrl: './editproducerprofile.component.html',
  styleUrls: ['./editproducerprofile.component.css']
})
export class EditproducerprofileComponent implements OnInit {

  users:User;
  producer=new Producer();
  user=new User();
  emailId;
  
  constructor(private activatedRoute:ActivatedRoute,private userService: UserService,private router: Router,private overlay:Overlay) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params=>{
      this.emailId=params.get('email');
      console.log(this.emailId);
    })
  }

  save(name,email,age,mobile){
    this.producer.name=name
    this.producer.emailId=email
    this.producer.age=age
    this.producer.mobileNo=mobile
    console.log(this.emailId);
    this.userService.updateProducer(this.emailId,this.producer).subscribe(data=>{
    console.log("update Request is successful ", data);},
    error=>{console.log("Error", error);})
    this.router.navigateByUrl('/producer/');
  }

}
