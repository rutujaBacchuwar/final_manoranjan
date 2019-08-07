import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user: User = new User();
  completeDetails = []
  genre = []
  temp:User=new User();

  firstFormGroup: FormGroup
  secondFormGroup: FormGroup

  constructor(private _formBuilder: FormBuilder, private _userService: UserService, private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      name: ['', Validators.compose([Validators.required, Validators.maxLength(25), Validators.pattern('^[a-zA-Z ]*$')])],
      emailId: ['', Validators.compose([Validators.required, Validators.pattern('[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}')])],

      password: ['', Validators.compose([Validators.minLength(5), Validators.required, Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@#$!%*?&])[A-Za-z\d$@#$!%*?&].{8,}')])]

    });
    this.secondFormGroup = this._formBuilder.group({
      age: ["", Validators.compose([Validators.required, Validators.pattern('^[0-9]{1,2}')])],
      gender: ["", Validators.compose([Validators.required])],
      mobileNo: ["", Validators.compose([Validators.maxLength(10), Validators.required,
      Validators.minLength(10), Validators.pattern("^[6-9][0-9]{9}")])]
    });
  }

  onSubmitViewerDetails(value) {
    console.log(value)
    this.completeDetails.push(value)
  }
  onSubmitMoreDetails(value) {
    console.log(value)
    this.completeDetails.push(value)
    console.log(this.completeDetails[1])

  }
  onSubmInterest(interest) {
    console.log(interest)
    this.completeDetails.push(interest)
    this.genre.push(interest);
    console.log(this.genre);
  }
  submitDetails() {
    var m = {
      'name': this.completeDetails[0].name,
      'emailId': this.completeDetails[0].emailId,
      'password': this.completeDetails[0].password,
      'age': this.completeDetails[1].age,
      'gender': this.completeDetails[1].gender,
      'mobileNo': this.completeDetails[1].mobileNo,
      'genre': this.genre,
      'role':"user",
      'wishListStandalone':[],
      'wishListEpisodic':[],
      'historyStandalone':[],
      'historyEpisodic':[]
    }

    this.temp.name=this.completeDetails[0].name;
    this.temp.emailId=this.completeDetails[0].emailId;
    this.temp.password=this.completeDetails[0].password;
    this.temp.age=this.completeDetails[1].age;
    this.temp.gender=this.completeDetails[1].gender;
    this.temp.mobileNo=this.completeDetails[1].mobileNo;
    this.temp.genre=this.genre;

    this.userService.saveUser(m).subscribe(data => {
      console.log("POST Request is successful ", data);
    },
      error => {
        console.log("Error", error);
      });

    this.router.navigateByUrl('/package/' + this.completeDetails[0].emailId);

  }

  validation_messages = {
    'name': [
      { type: 'required', message: 'Username is required' },
      { type: 'maxlength', message: 'Username cannot be more than 25 characters long' },
      { type: 'pattern', message: 'Your username must contain only numbers and letters' },
    ],

    'emailId': [
      { type: 'required', message: 'Email is required' },
      { type: 'pattern', message: 'Enter a valid email' }
    ],

    'password': [
      { type: 'required', message: 'Password is required' },
      { type: 'minlength', message: 'Password is at least 8 char long' },
      { type: 'pattern', message: ' password 8 char long ,has at least one uppercase, one lowercase, one number and one special character' }
    ],

    'age': [
      { type: 'required', message: 'age is required' },
      { type: 'pattern', message: 'enter valid age' }
    ],

    'gender': [
      { type: 'required', message: 'gender is required' },
    ],

    'mobileNo': [
      { type: 'required', message: 'mobileNo is required' },
      { type: 'minlength', message: 'mobileNo must be at 10 characters long' },
      { type: 'pattern', message: 'not a valid number' }
    ]

  }
}

