import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InvoiceComponent } from './invoice.component';
import { InvoiceDetialsComponent } from './invoice-detials/invoice-detials.component';
import { InvoiceRouteRoutes } from './invoice-route.routing';

@NgModule({
  imports: [
    CommonModule,
    InvoiceRouteRoutes
  ],
  declarations: [
    InvoiceComponent,
    InvoiceDetialsComponent
  ]
})
export class InvoiceModule { }
