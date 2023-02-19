import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientRegistrarionComponent } from './component/client-registrarion/client-registrarion.component';
import { LoginComponent } from './component/login/login.component';

const routes: Routes = [
  { path: '', component: ClientRegistrarionComponent },
  { path: 'registration', component: ClientRegistrarionComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
