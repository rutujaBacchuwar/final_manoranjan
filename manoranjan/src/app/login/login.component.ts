import { Component, OnInit } from '@angular/core';
import { Userauthen } from '../userauthen';
import { UserauthenService } from '../userauthen.service';
import {ActivatedRoute,Router} from '@angular/router';
import { ProducerdialogComponent } from '../producerdialog/producerdialog.component';
import { UserdialogComponent } from '../userdialog/userdialog.component';
import {MatDialog} from '@angular/material';

export interface DialogData {
  
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: Userauthen = new Userauthen();
  submitted: boolean;
  constructor(private router: Router, private route: ActivatedRoute, private userService: UserauthenService,public dialog: MatDialog) { }

  ngOnInit() {
  }
  submit(email, pass) {
    this.user.emailId = email;

    this.user.password = pass;
    console.log(this.user.emailId);

    this.userService.login(this.user).
      subscribe(
        (data: any) => {
          sessionStorage.setItem("email", this.user.emailId)
          if (data.message === "producer") {

            this.router.navigateByUrl('/producer');
           //this.router.navigateByUrl('/producerdialog');
            // const dialogRef = this.dialog.open(ProducerdialogComponent, {
            //   width: '350px',
            
            //   disableClose: true,
             
            // });
          }
          else if (data.message === "user") {
            this.router.navigateByUrl('/linkprilog');
           //this.router.navigateByUrl('/userdialog');
            // const dialogRef = this.dialog.open(UserdialogComponent, {
            //   width: '350px',
            
            //   disableClose: true,
             
            // });

          }

          console.log("POST Request is successful ", data);
        },
        error => {
          this.router.navigate(["/login"], { relativeTo: this.route });
          console.log("Error", error);
        }

      );
  }
  

}
