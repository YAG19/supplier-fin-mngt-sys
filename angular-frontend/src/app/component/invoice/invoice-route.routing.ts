import { Routes, RouterModule } from '@angular/router';
import { InvoiceDetialsComponent } from './invoice-detials/invoice-detials.component';
import { InvoiceUploadComponent } from './invoice-upload/invoice-upload.component';
import { InvoiceComponent } from './invoice.component';

const routes: Routes = [
    { path:'', component: InvoiceComponent},
    { path:'invoice-details', component: InvoiceDetialsComponent},
    { path:'invoice-upload', component: InvoiceUploadComponent}
];

export const InvoiceRouteRoutes = RouterModule.forChild(routes);
