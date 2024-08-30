import { TransactionDTO } from './beans/TransactionDTO';
import { environment } from './../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BeneficiaryDTO } from './beans/BeneficiaryDTO';
import { UserDTO } from './beans/UserDTO';

@Injectable({
  providedIn: 'root'
})
export class BankServiceService {

  url:string;
  constructor(private http:HttpClient) {
      this.url=environment.baseUrl;
   }

  addBeneficiary(beneficiaryDTO:BeneficiaryDTO){
      return this.http.post(this.url+"/addBeneficiary",beneficiaryDTO,{
        responseType:"text"
      });
  }

  checkBalance(accNumber){
    return this.http.get(this.url+`/checkBalance/${accNumber}`)
  }

  closeAccount(userDTO:UserDTO){
    return this.http.post(this.url+"/closeAccount",userDTO,{
      responseType:"text"
    });
  }

  creditAmount(creditDTO:TransactionDTO){
    return this.http.post(this.url+"/creditAmount",creditDTO,{
      responseType:"text"
    });
  }

  withdrawAmount(withdrawDTO:TransactionDTO){
    return this.http.post(this.url+"/withdrawAmount",withdrawDTO);
  }





}
