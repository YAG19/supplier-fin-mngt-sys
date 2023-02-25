import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, switchMap } from 'rxjs';
import { ClientService } from 'src/app/service/ClientService.service';
import { InvoiceService } from 'src/app/service/InvoiceService.service';
import { NotificationServiceService } from 'src/app/service/NotificationService.service';

@Component({
  selector: 'app-invoice-detials',
  templateUrl: './invoice-detials.component.html',
  styleUrls: ['./invoice-detials.component.css']
})
export class InvoiceDetialsComponent implements OnInit {
   userData$!: Observable<any>;
    // Define properties for supplier invoices
    supplierCode: string | undefined;
    invoiceNumber: string | undefined;
    invoiceDate: Date | undefined;
    invoiceAmount: number |  undefined;
    currency: string | undefined;
    invoiceStatus: string | undefined;
    data!: string | null;
  username: any;
  id: any;
  role: any;

    constructor(
      private route: ActivatedRoute,
      private service: ClientService,
      private invoiceService: InvoiceService,
      private notifyService: NotificationServiceService,
      ) { }

    ngOnInit(): void {

      let  data : string =  this.route.snapshot.paramMap.get('username') || "";
      this.username = data;

      this.invoiceService.getInvoiceDetails(this.username).subscribe(
        {
          next: (data) => {
            // this.notifyService.showSuccess("Successfully Uploaded Invoice","")

              this.supplierCode = data?.supplierCode;
              this.invoiceNumber = data?.invoiceNumber;
              this.invoiceDate = data?.invoiceDate;
              this.invoiceAmount = data?.invoiceAmount;
              this.currency = data?.currency;
              this.invoiceStatus = data?.invoiceStatus;
          },
          error: (err: any) => {
                        console.log(err);
                        const errorMsg = err?.error?.message;
                        this.notifyService.showWarning(errorMsg, "")
          },
          complete: () => { }
        }
      );
    }

}


