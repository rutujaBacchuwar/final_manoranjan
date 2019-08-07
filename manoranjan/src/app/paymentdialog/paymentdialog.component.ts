// import { Component, OnInit,Inject } from '@angular/core';
// import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
// @Component({
//   selector: 'app-paymentdialog',
//   templateUrl: './paymentdialog.component.html',
//   styleUrls: ['./paymentdialog.component.css']
// })
// export class PaymentdialogComponent implements OnInit {

//   constructor(public dialogRef: MatDialogRef<PaymentdialogComponent>,
//     @Inject(MAT_DIALOG_DATA) public data: any) { }

//   ngOnInit() {
//   }

// }
import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

export interface DialogData {
  
}
@Component({
  selector: 'app-paymentdialog',
  templateUrl: './paymentdialog.component.html',
  styleUrls: ['./paymentdialog.component.css']
})
export class PaymentdialogComponent implements OnInit {
  

  constructor(public dialogRef: MatDialogRef<PaymentdialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
      
     }

  ngOnInit() {
  }

}
