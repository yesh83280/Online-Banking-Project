import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AddBeneficiaryComponent } from './add-beneficiary/add-beneficiary.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CheckBalanceComponent } from './check-balance/check-balance.component';
import { CloseAccountComponent } from './close-account/close-account.component';
import { CreditAmountComponent } from './credit-amount/credit-amount.component';
import { WithdrawAmountComponent } from './withdraw-amount/withdraw-amount.component';
import { TemperatureComponent } from './temperature/temperature.component';


// const appRoutes: Routes = [
//   {
//     path:"addBeneficiary",
//     component:AddBeneficiaryComponent
//   }
// ];


@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent,
    AddBeneficiaryComponent,
    CheckBalanceComponent,
    CloseAccountComponent,
    CreditAmountComponent,
    WithdrawAmountComponent,
    TemperatureComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
