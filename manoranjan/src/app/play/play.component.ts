import { Component, OnInit, ViewChild, ElementRef, AfterViewInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { UserService } from '../user.service';


@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css']
})
export class PlayComponent implements OnInit, AfterViewInit {

  url1: SafeResourceUrl;
  url;
  title;
  id;
  status: string = "false";
  videoAvailable = false;
  @ViewChild('videoPlayer', { static: false }) video: ElementRef;
  constructor(private activatedRoute: ActivatedRoute, private sanitizer: DomSanitizer, private userService: UserService) {
  }

  ngAfterViewInit() {
    console.log(this.video)
    // this.video.nativeElement.play();

  }
  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.title = params.get('title')
      this.url = params.get('url')
      this.id = sessionStorage.getItem('email')
      console.log(this.url);
    });

    this.url = this.sanitizer.bypassSecurityTrustResourceUrl("rtmp://localhost:1935/vod/mp4:" + this.url);
    console.log(this.url, "laskjdlkajs")
    this.videoAvailable = true;
    if (sessionStorage.getItem('email') !== null) {
      this.status = "true";
    }
  }
}
