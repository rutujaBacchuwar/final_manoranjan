import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Router } from '@angular/router';


@Component({
  selector: 'app-userdialog',
  templateUrl: './userdialog.component.html',
  styleUrls: ['./userdialog.component.css']
})
export class UserdialogComponent implements OnInit {
  submitted: boolean;
  dialog: any;
  
  constructor(private router: Router,public dialogRef: MatDialogRef<UserdialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }
  submit(){
    this.router.navigateByUrl('/linkprilog');
    const dialogRef = this.dialog.open(UserdialogComponent, {
          width: '350px',
       
         
      });
      dialogRef.closed();
    dialogRef.afterClosed().subscribe(() => {
      console.log('The dialog was closed');
     
    });
  }
  
//   onSubmit() {
//     this.submitted = true;

    
//    const dialogRef = this.dialog.open(UserdialogComponent, {
//     width: '350px',
  
//     disableClose: true,
   
//   });

//   dialogRef.afterClosed().subscribe(() => {
//     console.log('The dialog was closed');
//   });
// }
}
