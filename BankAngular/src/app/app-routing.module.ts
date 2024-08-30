import { CheckBalanceComponent } from './check-balance/check-balance.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBeneficiaryComponent } from './add-beneficiary/add-beneficiary.component';
import { CloseAccountComponent } from './close-account/close-account.component';
import { CreditAmountComponent } from './credit-amount/credit-amount.component';
import { WithdrawAmountComponent } from './withdraw-amount/withdraw-amount.component';


const routes: Routes = [
  {
    path:"addBeneficiary",
    component:AddBeneficiaryComponent
  },
  {
    path:"checkBalance",
    component:CheckBalanceComponent
  },
  {
    path:"closeAccount",
    component:CloseAccountComponent
  },
  {
    path:"creditAmount",
    component:CreditAmountComponent
  },
  {
    path:"withdrawAmount",
    component:WithdrawAmountComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
