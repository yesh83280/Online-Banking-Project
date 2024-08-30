import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';

@Component({
  selector: 'app-check-balance',
  templateUrl: './check-balance.component.html',
  styleUrls: ['./check-balance.component.css']
})
export class CheckBalanceComponent implements OnInit {

  constructor(private bankService:BankServiceService) { }

  balance:number;
  accNumber:number;
  errorMsg=""

  ngOnInit() {
  }

  checkBalance(){
    console.log(this.accNumber);
    if(this.accNumber){
      this.bankService.checkBalance(this.accNumber).subscribe(
        (res:any)=>{
          console.log(res);
          this.balance=res;
        },
        (err:any)=>{
          console.log(err);
        }
      )
    }
    else{
      this.errorMsg="Please Enter value for all fields";
    }
  }

  closeMsg(){
    this.errorMsg="";
  }

}
