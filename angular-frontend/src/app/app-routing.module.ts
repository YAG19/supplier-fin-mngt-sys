import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientRegistrarionComponent } from './component/client-registrarion/client-registrarion.component';
import { HomeComponent } from './component/home/home.component';
import { InvoiceUploadComponent } from './component/invoice-upload/invoice-upload.component';
import { InvoiceDetialsComponent } from './component/invoice/invoice-detials/invoice-detials.component';
import { InvoiceComponent } from './component/invoice/invoice.component';
import { LoginComponent } from './component/login/login.component';
import { SupplierRegistrationComponent } from './component/supplier-registration/supplier-registration.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'client-registration', component: ClientRegistrarionComponent },
  { path: 'supplier-registration', component: SupplierRegistrationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'invoice-upload', component: InvoiceUploadComponent },
  { path: 'invoice', children: [
    {
      path: 'invoice-details',
      component: InvoiceDetialsComponent
    }
    ],
  },
  { path: 'invoice', component: InvoiceComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
