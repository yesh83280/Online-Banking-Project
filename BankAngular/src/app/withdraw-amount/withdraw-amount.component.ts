import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';
import { TransactionDTO } from '../beans/TransactionDTO';

@Component({
  selector: 'app-withdraw-amount',
  templateUrl: './withdraw-amount.component.html',
  styleUrls: ['./withdraw-amount.component.css']
})
export class WithdrawAmountComponent implements OnInit {

  constructor(private bankService:BankServiceService) { 
    this.withdrawDTO=new TransactionDTO()
    this.withdrawDTO.transactionType="Withdraw";
  }

  withdrawDTO:TransactionDTO;
  successMsg:string="";
  errorMsg:string="";

  ngOnInit() {
  }

  withdrawAmount(){
    this.successMsg="";
    this.errorMsg="";
    console.log(this.withdrawDTO)
    if(this.withdrawDTO.accNumber==null || this.withdrawDTO.amount==null){
      this.errorMsg="Please Enter value for all fields";
    }
    else if(this.withdrawDTO.amount<=0){
      this.errorMsg="Please Enter withdraw amount greater than zero";
    }
    else if(this.withdrawDTO.accNumber<=0){
      this.errorMsg="Please Enter valid account details";
    }
    else{
    this.bankService.withdrawAmount(this.withdrawDTO).subscribe(
      (res:any)=>{
        console.log(res,res["status"],res["message"]);
        if(res["status"]==true){
          this.successMsg=res["message"];
          this.withdrawDTO=new TransactionDTO();
        }
        else{
          this.errorMsg=res["message"];
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
