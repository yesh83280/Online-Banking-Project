import { TransactionDTO } from './../beans/TransactionDTO';
import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';

@Component({
  selector: 'app-credit-amount',
  templateUrl: './credit-amount.component.html',
  styleUrls: ['./credit-amount.component.css']
})
export class CreditAmountComponent implements OnInit {

  constructor(private bankService:BankServiceService) { 
    this.creditDTO=new TransactionDTO()
    this.creditDTO.transactionType="Credit";
  }

  creditDTO:TransactionDTO;
  successMsg:string="";
  errorMsg:string="";

  ngOnInit() {
  }

  creditAmount(){
    this.successMsg="";
    this.errorMsg="";
    if(this.creditDTO.accNumber==null || this.creditDTO.amount==null){
      this.errorMsg="Please Enter value for all fields";
    }
    else if(this.creditDTO.amount<=0){
      this.errorMsg="Please Enter credit amount greater than zero";
    }
    else if(this.creditDTO.accNumber<=0){
      this.errorMsg="Please Enter valid account details";
    }
    else{
      console.log(this.creditDTO)
    this.bankService.creditAmount(this.creditDTO).subscribe(
      (res:any)=>{
        console.log(res);
        if(res){
          this.successMsg=res;
          this.creditDTO=new TransactionDTO();
        }
        else{
          this.errorMsg="Please Enter a valid account details";
        }
      },
      (err:any)=>{
        this.errorMsg="Please Enter a valid account details";
        console.log(err);
      }
    )
    }
  }

  closeMsg(){
    this.successMsg="";
    this.errorMsg="";
  }

}
