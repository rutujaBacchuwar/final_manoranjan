import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StandaloneMedia } from '../standalone-media';
import { Episodic } from '../episodic';
import { StandaloneService } from '../standalone.service';
import { EpisodicService } from '../episodic.service';

@Component({
  selector: 'app-linkpriviewlogin',
  templateUrl: './linkpriviewlogin.component.html',
  styleUrls: ['./linkpriviewlogin.component.css']
})
export class LinkpriviewloginComponent implements OnInit {

  heading1 = "Movies";
  heading2 = "Tv Episodes";
  heading3 = "Web series";
  heading4 = "Documentries";

  allMedia;
  allMedia1 = new Array<StandaloneMedia>()
  movie = new Array<StandaloneMedia>()

  docs = new Array<StandaloneMedia>();

  weblist;
  weblist2 = new Array<Episodic>();
  web = new Array<Episodic>();

  tvlist;
  tvlist2 = new Array<Episodic>();
  tv = new Array<Episodic>();
  constructor(private standaloneService:StandaloneService,private episodicService:EpisodicService) { }

  ngOnInit() {
    this.episodicService.getEpisodic("Web Series").subscribe(data => {
      this.weblist = data
      this.weblist2 = this.weblist
      this.weblist2.forEach(element => {
        if (element.episodicType === "premium") {
          this.web.push(element)
          console.log(element)
        }
      });
      console.log("list" + this.weblist2)
      console.log(this.web)
    });

    this.episodicService.getEpisodic("TV Episodes").subscribe(data => {
      this.tvlist = data
      this.tvlist2 = this.tvlist
      this.tvlist2.forEach(element => {
        if (element.episodicType === "premium") {
          this.tv.push(element)
          console.log(element)
        }
      });
      console.log("list" + this.tvlist2)
      console.log(this.tv)
    });

    this.standaloneService.getAllMedia().subscribe(data => {
      this.allMedia = data;
      this.allMedia1 = this.allMedia
      console.log(this.allMedia)
      this.allMedia1.forEach(element => {
        if (element.mediaCategory === "Movie") {
          if (element.mediaType === "premium") {
            this.movie.push(element)
          }
        }
        if (element.mediaCategory == "Documentary") {
          if (element.mediaType == "premium") {
            this.docs.push(element)
          }
        }
      });
    })
  }

}
