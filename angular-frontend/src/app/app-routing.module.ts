import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientRegistrarionComponent } from './component/client-registrarion/client-registrarion.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { SupplierRegistrationComponent } from './component/supplier-registration/supplier-registration.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'client-registration', component: ClientRegistrarionComponent },
  { path: 'supplier-registration', component: SupplierRegistrationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'invoice',
     loadChildren: () => import('./component/invoice/invoice.module').then(m => m.InvoiceModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
