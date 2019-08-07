import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { FormBuilder, Form } from '@angular/forms';
import { Userpayment } from '../userpayment';
import { PaymentService } from '../payment.service';
import { Cardinfo } from '../cardinfo';
import {MatDialog} from '@angular/material';
import { DatePipe } from '@angular/common';
import { PaymentdialogComponent } from '../paymentdialog/paymentdialog.component';


export interface DialogData {
  
}

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
ptime;
  user= new User();
  payment=new Userpayment();
  emailId;packageName;
   time;
   amount; date=new Date();
  cardName;cardNumber;expiryMonth;expiryYear;cvv;
   route:any;
  form: Form;
  cardinfo = new Cardinfo();
  submitted: boolean;
  registerForm: any;

  constructor(private router:Router,
    private activatedRoute:ActivatedRoute,private paymentservice:PaymentService,public dialog: MatDialog) {
      }
    submit(time,amount,cardName,cardNumber,expiryMonth,expiryYear,cvv){
      this.time=time;
      this.cardinfo.cardName=cardName;
      this.cardinfo.cardNumber=cardNumber;
      this.cardinfo.expiryMonth=expiryMonth;
      this.cardinfo.expiryYear=expiryYear;
      this.cardinfo.cvv=cvv;
          (<any>window).Stripe.card.createToken({
            number:this.cardinfo.cardNumber,
            exp_month: this.cardinfo.expiryMonth,
            exp_year: this.cardinfo.expiryYear,
            cvc: this.cardinfo.cvv
      }, (status:number, response: any) => {
            if (status === 200) {
             let token = response.id;
              console.log(token);
            this.payment.emailId=this.user.emailId;
            this.payment.packageName=time;
            sessionStorage.setItem("packageTime",this.payment.packageName)
            this.payment.mydate=this.date;
      this.paymentservice.save(this.payment).
        subscribe(
            data => {
              this.ptime=sessionStorage.getItem('packageTime');
             // this.router.navigateByUrl('/paymentdialog/'+this.ptime+'/'+amount);
              console.log("POST Request is successful ", data)
              const dialogRef = this.dialog.open(PaymentdialogComponent, {
                width: '350px',
              
                disableClose: true,
               
              });
            },
            error => {
              console.log("1234567")
              this.router.navigate(['/payment/' + time + '/' + amount], { relativeTo: this.route });
              console.log("Error", error);
            }
          );
        console.log("fdsad")
      }
      else {
        console.log(response.error.message);
      }
    });
  }
  ngOnInit() {
    this.user.emailId = sessionStorage.getItem('email');
    console.log(this.user.emailId);
    this.time = sessionStorage.getItem('time');
    this.activatedRoute.paramMap.subscribe(params => {
      this.time = params.get('time');
      this.amount = params.get('amount');
      console.log("time- " + this.time + " amount- " + this.amount);
    });
  }
  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }

   const dialogRef = this.dialog.open(PaymentdialogComponent, {
    width: '350px',
  
    disableClose: true,
   
  });

  dialogRef.afterClosed().subscribe(() => {
    console.log('The dialog was closed');
  });
}
}
