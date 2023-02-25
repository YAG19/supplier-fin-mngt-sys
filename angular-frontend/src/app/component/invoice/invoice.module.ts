import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InvoiceComponent } from './invoice.component';
import { InvoiceDetialsComponent } from './invoice-detials/invoice-detials.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    InvoiceComponent,
    InvoiceDetialsComponent
  ]
})
export class InvoiceModule { }
