import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientRegistrarionComponent } from './component/client-registrarion/client-registrarion.component';

const routes: Routes = [
{ path: '', component: ClientRegistrarionComponent } ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
