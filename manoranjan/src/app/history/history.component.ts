import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { EpisodicService } from '../episodic.service';
import { StandaloneService } from '../standalone.service';
import { StandaloneMedia } from '../standalone-media';
import { Episodic } from '../episodic';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  id;
  media: any;
  standalone:any;
  standalone1:Array<StandaloneMedia>;
  episodic:any;
  episodic1:Array<Episodic>;
  nomedia:string="true";

  constructor(private userService:UserService,private episodicService:EpisodicService,
    private standaloneService:StandaloneService) { 
      this.standalone=false;
      this.episodic=false;
    }

  ngOnInit() {
    this.id=sessionStorage.getItem('email');
    if(this.id!==null){
      this.userService.getEpisodicHistory(this.id).subscribe((data:any)=>{
        this.episodicService.getWishlist(data).subscribe(list=>{
          console.log("episodic"+list);
          this.episodic=list;
          this.episodic1=this.episodic;
          console.log(this.episodic1);
          this.nomedia="false";
        })
      });
      this.userService.getStandaloneHistory(this.id).subscribe((data:any)=>{
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
}
