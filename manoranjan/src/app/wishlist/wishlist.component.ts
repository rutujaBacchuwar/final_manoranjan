import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StandaloneService } from '../standalone.service';
import { EpisodicService } from '../episodic.service';
import { UserService } from '../user.service';
import { StandaloneMedia } from '../standalone-media';
import { Episodic } from '../episodic';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {

  id;
  media: any;
  standalone:any;
  standalone1:Array<StandaloneMedia>;
  episodic:any;
  episodic1:Array<Episodic>;
  nomedia:string="true";
  constructor(private standaloneService: StandaloneService,private episodicService:EpisodicService, 
    private router: Router,private userService:UserService) {

      this.standalone=false;
      this.episodic=false;
  }

  ngOnInit() {

    this.id=sessionStorage.getItem('email');
    if(this.id!==null){
      this.userService.getEpisodicWishlist(this.id).subscribe((data:any)=>{
        this.episodicService.getWishlist(data).subscribe(list=>{
          console.log("episodic"+list);
          this.episodic=list;
          this.episodic1=this.episodic;
          console.log(this.episodic1);
          this.nomedia="false";
        })
      });
      this.userService.getStandaloneWishlist(this.id).subscribe((data:any)=>{
        this.standaloneService.getWishlist(data).subscribe(list=>{
          console.log("standalone - "+list);
          this.standalone=list;
          this.standalone1=this.standalone;
          console.log(this.standalone1);
          this.nomedia="false";
        })
      })
    }
  }
  sendDetails(serial) {
    let x = JSON.stringify(serial)
    sessionStorage.setItem("serial", x);
    console.log(serial.episodicTitle)
    this.router.navigateByUrl("/image");
  }
}
