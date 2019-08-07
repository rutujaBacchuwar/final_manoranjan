import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

import { ActivatedRoute, Router } from '@angular/router';
import { HttpResponse, HttpEventType } from '@angular/common/http';
import { Crew } from '../crew';
import { Cast } from '../cast';
import { Episode } from '../episode';
import { EpisodicService } from '../episodic.service';
import { StandaloneService } from '../standalone.service';
import { Producer } from '../producer';
import { UserService } from '../user.service';
@Component({
  selector: 'app-episodic',
  templateUrl: './episodic.component.html',
  styleUrls: ['./episodic.component.css']
})
export class EpisodicComponent implements OnInit {
  
  producer = new Producer();
  episodePreview = [];
  episodeNo:Number;
  episodeUrl;
  episodeDescription;
  episodePosterUrl;
  episodeReleaseDate;

  episodeData:Episode=new Episode();

  firstFormGroup: FormGroup
  secondFormGroup: FormGroup
  thirdFormGroup: FormGroup
  sixthFormGroup: FormGroup
  seventhFormGroup: FormGroup
  eightFormGroup: FormGroup

  
  episodeDetails = []

  currentFileUpload: File;
  selectedVideo: FileList;

  title;
  category;
  synopsis;
  episodeName;

  crewList = [];
  crewName;
  crewRole;
  castList = [];
  screenName;
  realName;

  listEpisode:Array<Episode>=new Array();

  progress: { percentage: number } = { percentage: 0 };

  constructor(private _formBuilder: FormBuilder, private router: Router,
    private mediaService: StandaloneService, private activatedRoute: ActivatedRoute,
    private episodicService:EpisodicService,private userService:UserService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.title = params.get('title');
      this.category = params.get('category');
      this.synopsis = params.get('synopsis');
      console.log("title- " + this.title + " category- " + this.category + " synopsis- " + this.synopsis);
    });

    this.firstFormGroup = this._formBuilder.group({
      episodeLanguage: new FormControl('', Validators.compose([Validators.required])),
      episodePoster: new FormControl('', Validators.compose([Validators.required])),
      episodeType: new FormControl('', Validators.compose([Validators.required])),
    });

    this.secondFormGroup = this._formBuilder.group({
      EpisodeStudioName: new FormControl('', Validators.compose([Validators.pattern('^[a-zA-z. ]*$')]))
    });

    this.thirdFormGroup = this._formBuilder.group({
    });

    this.sixthFormGroup = this._formBuilder.group({
      crewName: new FormControl('', Validators.compose([Validators.pattern('^[a-zA-Z. ]*$')])),
      crewRole: new FormControl(),
    });

    this.seventhFormGroup = this._formBuilder.group({
      screenName: new FormControl('', Validators.compose([Validators.pattern('^[a-zA-Z. ]*$')])),
      realName: new FormControl('', Validators.compose([Validators.pattern('^[a-zA-Z. ]*$')]))
    });

    this.eightFormGroup = this._formBuilder.group({
      episodeNo: new FormControl('', Validators.compose([Validators.maxLength(20)])),
      episodeUrl: new FormControl(),
      episodeDescription: new FormControl('', Validators.compose([Validators.maxLength(100)])),
      episodePosterUrl: new FormControl(),
      episodeReleaseDate: new FormControl()
    });
  }
  // ng oninit closed
  validation_messages = {
    'crewName': [
      { type: 'pattern', message: 'Your crewname must contain only characters' },
      { type: 'validUsername', message: 'Your username has already been taken' }
    ],
    'screenName': [
      { type: 'pattern', message: 'Your screenName must contain only characters' },
      { type: 'validUsername', message: 'Your username has already been taken' }
    ],
    'EpisodeStudioName': [
      { type: 'pattern', message: 'Your screenName must contain only characters' },
      { type: 'validUsername', message: 'Your username has already been taken' }
    ],
    'episodePoster': [
      { type: 'required', message: 'episode poster url is required' }
    ],
    'realName': [
      { type: 'pattern', message: 'Your realname must contain only characters' },
      { type: 'validUsername', message: 'Your username has already been taken' }
    ],
  }

  addEpisode(episodeNumber, video, desc, poster, dateRelease) {

    // this.episodeData.episodeNo=episodeNumber;
    // this.episodeData.episodeUrl=video;
    // this.episodeData.episodeDescription=desc;
    // this.episodeData.episodePosterUrl=poster;
    // this.episodeData.episodeReleaseDate=dateRelease;
    // this.listEpisode.push(this.episodeData);
    console.log("Hello episode",episodeNumber);
    let n=parseInt(episodeNumber);
    console.log("Hello episode",n);
    console.log("Hello",dateRelease);
    let newDate = new Date(dateRelease);
    console.log("Hello",newDate);
    this.episodePreview.push(
      {
        episodeNo: n,
        episodeUrl: this.episodeName,
        episodeDescription: desc,
        episodePosterUrl: poster,
        episodeReleaseDate: newDate
      });

    console.log(this.episodePreview);
  }

  deleteEpisode(episodeNumber, video, desc, poster, dateRelease) {
    console.log(episodeNumber, video, desc, poster, dateRelease);
    for (var i = 0; i < this.episodePreview.length; i++) {
      if (this.episodePreview[i]["episodeNo"] == episodeNumber) {
        this.episodePreview.splice(i, 1);
      }
    }
  }

  addCrew(name, role) {
    this.crewList.push(
      { crewName: name, crewRole: role }
    );
    console.log(this.crewList);
  }

  deleteCrew(name, role) {
    console.log(name, role);
    for (var i = 0; i < this.crewList.length; i++) {
      if (this.crewList[i]["crewName"] == name) {
        this.crewList.splice(i, 1);
      }
    }
  }
  addCast(screen, real) {
    this.castList.push(
      { screenName: screen, realName: real }
    )
    console.log(this.castList);
  }

  deleteCast(screenName, realName) {
    console.log(screenName, realName);
    for (var i = 0; i < this.castList.length; i++) {
      if (this.castList[i]["screenName"] == screenName) {
        this.castList.splice(i, 1);
      }
    }
  }

  onFirstSubmit(value) {
    console.log("first");
    console.log(value);
    this.episodeDetails.push(value);
  }

  onSecondSubmit(value) {
    console.log("second");
    console.log(value);
    this.episodeDetails.push(value);
  }

  onThirdSubmit(value) {
    console.log("third");
    console.log(value);
    this.episodeDetails.push(value);
  }

  selectVideo(event) {
    this.selectedVideo = event.target.files;
  }

  uploadVideo() {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedVideo.item(0)
    this.mediaService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      }
      else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
        this.episodeName = this.currentFileUpload.name;
      }
    })
    this.selectedVideo = undefined
  }

  saveMedia() {

    var video = {
      'episodicTitle': this.title,
      'episodicCategory': this.category,
      'episodicSynopsis': this.synopsis,
      'episodicLanguage': this.episodeDetails[0].episodeLanguage,
      'episodicPosterUrl': this.episodeDetails[0].episodePoster,
      'episodicStudioName': this.episodeDetails[1].EpisodeStudioName,
      'episodicCrew': this.crewList,
      'episodicCast': this.castList,
      'episodeList': this.episodePreview,
      'episodicType': this.episodeDetails[0].episodeType
    };

    console.log("video ", JSON.stringify(video, null, 1))
    this.episodicService.saveEpisodicMedia(video).subscribe(com => {
      console.log("saved");
      console.log(com)
    },
      error => {
        console.log(error)
      });


    this.producer.emailId = sessionStorage.getItem('email');
    console.log(this.producer.emailId)
    console.log(this.title)
   this.userService.updateUploadedEpisodic(this.producer.emailId,this.title).subscribe(com=>{
     console.log("saved");
     console.log(com)
   },
   error=>{
     console.log(error)
   });
  }
}
