import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Producer } from '../producer';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { StandaloneMedia } from '../standalone-media';
import { Episodic } from '../episodic';
import { StandaloneService } from '../standalone.service';
import { EpisodicService } from '../episodic.service';

@Component({
  selector: 'app-producerprofile',
  templateUrl: './producerprofile.component.html',
  styleUrls: ['./producerprofile.component.css']
})
export class ProducerprofileComponent implements OnInit {

  heading1="Movies and Documentries"
  heading2="Tv-Shows and Web-Series"
  id;
  media: any;
  standalone:any;
  standalone1:Array<StandaloneMedia>;
  episodic:any;
  episodic1:Array<Episodic>;
  nomedia:string="true";
  users: User;
  producer=new Producer();
  producers:Producer;
  producers1:Producer;
  listTitle:Array<string>=new Array();
  listTitle1:Array<string>=new Array();
  user = new User();
  emailId;
  private photo:string;
  constructor(private userService: UserService,private router:Router,private standaloneService: StandaloneService,private episodicService:EpisodicService) { }

  ngOnInit() {
    // this.producer.emailId = sessionStorage.getItem('email');
    // console.log(this.producer.emailId);
    this.userService.getByEmailId(sessionStorage.getItem('email')).subscribe(data => {
      this.producer = data;
      console.log("POST Request is successful ", data);
      console.log("gender:",this.producer.gender);
      if(this.producer.gender=='male'|| this.producer.gender=='Male')
      {
        this.photo='maleDemo.png';
        console.log("male is here");
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

    this.userService.getUploadedStandaloneTitle(sessionStorage.getItem('email')).subscribe(data=>{
      // this.producers=data;
      this.listTitle=data;
      // console.log(this.producers);
      this.standaloneService.getWishlist(this.listTitle).subscribe(list=>{
        console.log("standalone - "+list);
        this.standalone=list;
        this.standalone1=this.standalone;
        console.log(this.standalone1);
         this.nomedia="false";
      })
    })

    this.userService.getUploadedEpisodicTitle(sessionStorage.getItem('email')).subscribe(data=>{
      // this.producers1=data;
      this.listTitle1=data;
      // console.log(this.producers1);
      this.episodicService.getWishlist(this.listTitle1).subscribe(list1=>{
        console.log("episodic"+list1);
        this.episodic=list1;
        this.episodic1=this.episodic;
        console.log(this.episodic1);
        this.nomedia="false";
      })
    })

  }
  sendEmail(email)
  {
     this.router.navigateByUrl('/editpro/'+email);
  }
}
