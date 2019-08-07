import { Component, OnInit,Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
@Component({
  selector: 'app-producerdialog',
  templateUrl: './producerdialog.component.html',
  styleUrls: ['./producerdialog.component.css']
})
export class ProducerdialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ProducerdialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

}
