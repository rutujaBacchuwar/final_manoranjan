import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Crew } from '../crew';
import { Cast } from '../cast';
import { StandaloneService } from '../standalone.service';
import { StandaloneMedia } from '../standalone-media';
import { UserService } from '../user.service';
import { Producer } from '../producer';

@Component({
  selector: 'app-standalone-stepper',
  templateUrl: './standalone-stepper.component.html',
  styleUrls: ['./standalone-stepper.component.css']
})
export class StandaloneStepperComponent implements OnInit {

  crewList = [];
  crewName;
  crewRole;

  castList = [];
  screenName;
  realName;

  myGroup: FormGroup;
  [x: string]: any;
  user: User = new User();
  mediaDetails = [];

  hide: true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  sixthFormGroup: FormGroup;
  seventhFormGroup: FormGroup;

  title;
  category;
  synopsis;

  currentFileUpload: File;
  selectedVideo: FileList;
  selectedTrailer: FileList;

  mediaName;
  trailerName;

  producer = new Producer();

  progress: { percentage: number } = { percentage: 0 };

  media: StandaloneMedia = new StandaloneMedia();
  crew: Crew = new Crew();
  cast: Cast = new Cast();
  listCrew: Array<Crew> = new Array<Crew>();
  listCast: Array<Cast> = new Array<Cast>();

  genres: Array<string> = new Array<string>();

  constructor(private _formBuilder: FormBuilder, private router: Router,
    private mediaService: StandaloneService, private activatedRoute: ActivatedRoute,private userService: UserService) { }

  ngOnInit() {

    this.activatedRoute.paramMap.subscribe(params => {
      this.title = params.get('title');
      this.category = params.get('category');
      this.synopsis = params.get('synopsis');
      console.log("title- " + this.title + " category- " + this.category + " synopsis- " + this.synopsis);
    });

    this.firstFormGroup = this._formBuilder.group({

      date:new FormControl("" , Validators.compose([Validators.required]))

      });
    this.secondFormGroup = this._formBuilder.group({
      studio: new FormControl('', [Validators.required, Validators.maxLength(50), Validators.pattern('^[a-zA-Z. ]*$')])
    });
    this.thirdFormGroup = this._formBuilder.group({

      language: new FormControl('', [Validators.required]),
      video:new FormControl(),
      trailer:new FormControl(),
      type:new FormControl('', [Validators.required]),
      posterurl: new FormControl('', [Validators.required])
     
    });

    this.sixthFormGroup = this._formBuilder.group({
      crewName: new FormControl("", Validators.pattern('^[a-zA-Z. ]*$')),
      crewRole: new FormControl(),
    });
    this.seventhFormGroup = this._formBuilder.group({
      screenName: new FormControl("", Validators.pattern('^[a-zA-Z. ]*$')),
      realName: new FormControl("", Validators.pattern('^[a-zA-Z. ]*$')),
    });
  }

  addCrew(name, role) {
    this.crewList.push(
      { crewName: name, crewRole: role }
    )
    console.log(this.crewList);
  }
  deleteCrew(crewName, crewRole) {
    console.log(crewName, crewRole);
    for (var i = 0; i < this.crewList.length; i++) {
      if (this.crewList[i]["crewName"] == crewName) {
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

  getErrorMessage() {
    return this.email.hasError('required') ? 'You must enter a value' :
      this.email.hasError('email') ? 'Not a valid email' : '';
  }

  onFirstSubmit(value) {
    console.log("first");
    console.log(value);
    this.mediaDetails.push(value);
  }

  onSecondSubmit(value) {
    console.log(value);
    this.mediaDetails.push(value);
  }

  onThirdSubmit(value) {
    console.log(value);
    this.mediaDetails.push(value);
  }
  onSubmInterest(value) {
    console.log(value);
    this.genres.push(value);
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
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
        this.mediaName = this.currentFileUpload.name;
      }
    })
    this.selectedVideo = undefined
  }

  selectTrailer(event) {
    this.selectedTrailer = event.target.files;
  }

  uploadTrailer() {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedTrailer.item(0)
    this.mediaService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
        this.trailerName = this.currentFileUpload.name;
      }
    })
    this.selectedTrailer = undefined
  }

  saveMedia() {
    this.crew.crewName = this.mediaDetails[1].crewName;
    this.crew.crewRole = this.mediaDetails[1].crewRole;
    this.listCrew.push(this.crew);

    this.cast.screenName = this.mediaDetails[1].screenName;
    this.cast.realName = this.mediaDetails[1].realName;
    this.listCast.push(this.cast);
    let newDate = new Date(this.mediaDetails[0].date);
    var video = {
      'mediaTitle': this.title,
      'mediaCategory': this.category,
      'mediaSynopsis': this.synopsis,
      'mediaLanguage': this.mediaDetails[2].language,
      'mediaReleaseDate': newDate,
      'mediaStudioName': this.mediaDetails[1].studio,
      'mediaCrew': this.crewList,
      'mediaCast': this.castList,
      'mediaPosterUrl': this.mediaDetails[2].posterurl,
      'mediaType': this.mediaDetails[2].type,
      'mediaUrl': this.mediaName,
      'mediaTrailerUrl': this.trailerName,
      'mediaGenre': this.genres
    };

    this.mediaService.saveMedia(video).subscribe(com => {
      console.log("saved");
      console.log(com)
    },
      error => {
        console.log(error)
      });

    this.producer.emailId = sessionStorage.getItem('email');
    console.log(this.producer.emailId)
    console.log(this.title)
   this.userService.updateUploadedStandalone(this.producer.emailId,this.title).subscribe(com=>{
     console.log("saved");
     console.log(com)
   },
   error=>{
     console.log(error)
   });
  }
  validation_messages = {
    'studio': [
      { type: 'required', message: 'Studio name is required' },
      { type: 'validUsername', message: 'Your username has already been taken' },
      { type: 'pattern', message: 'studio name must contain only characters' }
    ],
    'posterurl': [
      { type: 'required', message: 'poster url is required' },
    ],
    'crewName': [
      { type: 'pattern', message: 'crew name must contain only characters' }
    ],
    'screenName': [
      { type: 'pattern', message: 'screen name must contain only characters' }
    ],
    'realName': [
      { type: 'pattern', message: 'real name must contain only characters' }
    ]

  }

}