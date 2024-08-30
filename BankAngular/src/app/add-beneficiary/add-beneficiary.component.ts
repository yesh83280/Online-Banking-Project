import { BeneficiaryDTO } from './../beans/BeneficiaryDTO';
import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';

@Component({
  selector: 'app-add-beneficiary',
  templateUrl: './add-beneficiary.component.html',
  styleUrls: ['./add-beneficiary.component.css']
})
export class AddBeneficiaryComponent implements OnInit {

  constructor(private bankService:BankServiceService) { }

  beneficiaryDTO:BeneficiaryDTO=new BeneficiaryDTO();
  successMsg=""
  errorMsg=""

  ngOnInit() {
  }

  onSubmit(){
    this.successMsg="";
    this.errorMsg="";
    console.log(this.beneficiaryDTO);
    this.bankService.addBeneficiary(this.beneficiaryDTO).subscribe(
      (res:any)=>{
        if(res){
          this.successMsg=res;
          this.beneficiaryDTO=new BeneficiaryDTO();
        }
        else{
          this.errorMsg="Failed to add Beneficiary";
        }
      },
      (err:any)=>{
        console.log(err);
      }
    )
  }

  closeMsg(){
    console.log("Hi")
    this.successMsg="";
    this.errorMsg="";
  }

  onCancel(){
    this.successMsg="";
    this.errorMsg="";
    this.beneficiaryDTO=new BeneficiaryDTO();
  }

}
