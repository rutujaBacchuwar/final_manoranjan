import { Component, OnInit, AfterViewInit, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { UserService } from '../user.service';


import * as videojs from 'video.js';
import "@videojs/http-streaming";
import "videojs-flash";
import "videojs-contrib-eme";
import "dashjs";


@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css']
})
export class PlayComponent implements OnInit, AfterViewInit {

  url;
  title;
  category;
  id;
  status:string ="false";
  video_xyz;

  @ViewChild('videoPlayer', { static: false }) video: ElementRef;
  
  constructor(private activatedRoute:ActivatedRoute,private sanitizer:DomSanitizer,private userService:UserService) {
   }
  
  ngAfterViewInit() {
    this.video_xyz = videojs(this.video.nativeElement, {
      "width": "100%"
    })
    this.video_xyz.play();

  }
  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.title = params.get('title')
      this.url = params.get('url')
      this.id=sessionStorage.getItem('email')
      console.log(this.url);
    });

    this.url=this.sanitizer.bypassSecurityTrustResourceUrl("rtmp://13.235.52.81:1935/vod/mp4:"+this.url);
    if(sessionStorage.getItem('email')!==null){
      this.status="true";
    }
  }
}
