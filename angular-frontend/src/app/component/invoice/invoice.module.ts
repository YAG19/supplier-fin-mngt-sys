import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InvoiceComponent } from './invoice.component';
import { InvoiceDetialsComponent } from './invoice-detials/invoice-detials.component';
import { InvoiceRouteRoutes } from './invoice-route.routing';
import { InvoiceUploadComponent } from './invoice-upload/invoice-upload.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    InvoiceRouteRoutes,
  ],
  declarations: [
    InvoiceComponent,
    InvoiceUploadComponent,
    InvoiceDetialsComponent
  ]
})
export class InvoiceModule { }
