import { Component, OnInit } from '@angular/core';
import { BankServiceService } from '../bank-service.service';
import { UserDTO } from '../beans/UserDTO';

@Component({
  selector: 'app-close-account',
  templateUrl: './close-account.component.html',
  styleUrls: ['./close-account.component.css']
})
export class CloseAccountComponent implements OnInit {

  constructor(private bankService:BankServiceService) { }

  userDTO:UserDTO=new UserDTO();
  successMsg:string="";
  errorMsg:string="";

  ngOnInit() {
  }

  closeAccount(){
    this.successMsg="";
    this.errorMsg="";
    console.log(this.userDTO);
    this.bankService.closeAccount(this.userDTO).subscribe(
      (res:any)=>{
        console.log(res);
        if(res=="true"){
          this.successMsg="Account Deleted Successfully";
          this.userDTO=new UserDTO();
        }
        else{
          this.errorMsg="Invalid Account Number or Password";
        }
      },
      (err:any)=>{
        console.log(err);
      }
    )
  }

  closeMsg(){
    this.successMsg="";
    this.errorMsg="";
  }

}
