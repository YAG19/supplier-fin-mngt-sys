import { Routes, RouterModule } from '@angular/router';
import { InvoiceDetialsComponent } from './invoice-detials/invoice-detials.component';

const routes: Routes = [
    { path:'', component: InvoiceDetialsComponent},
    { path:'invoice-details', component: InvoiceDetialsComponent}
];

export const InvoiceRouteRoutes = RouterModule.forChild(routes);
