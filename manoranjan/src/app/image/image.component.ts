import { Component, OnInit } from '@angular/core';
import { Episodic } from '../episodic';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {

  id;
  status:string ="false";
  serial;
  serial1 = new Episodic()
  episodeList;
  constructor(private router: Router,private userService:UserService) { }
  title;
  ngOnInit() {
    this.serial=JSON.parse(sessionStorage.getItem("serial"));
    this.serial1=this.serial
    this.episodeList=this.serial.episodeList
    this.title=this.serial.episodicTitle
    if(sessionStorage.getItem('email')!==null){
      this.status="true";
    }
  }

  playVideo() {
    this.id = sessionStorage.getItem('email')
    console.log();
    if(this.serial1.episodicType==="premium"){
      if(this.id!==null){
        this.router.navigateByUrl('/play/'+this.serial.episodicTitle+'/'+this.serial1.episodeList[0].episodeUrl);
      }
      else{
        this.router.navigateByUrl('/login');
      }
    }
    else{
      this.router.navigateByUrl('/play/'+this.serial.episodicTitle+'/'+this.serial1.episodeList[0].episodeUrl);
    }
  }

  addWishlist(title){
    this.id = sessionStorage.getItem('email')
    console.log(this.id)
    if(this.id!==null){
      this.userService.addToEpisodicWishlist(this.id,title).subscribe(data=>{
        console.log(data);
      })
    }
    else{
      this.router.navigateByUrl('/login');
    }
  }
}
