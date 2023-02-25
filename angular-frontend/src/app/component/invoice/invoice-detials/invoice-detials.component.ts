import { JsonPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, switchMap } from 'rxjs';
import { ClientService } from 'src/app/service/ClientService.service';

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

    constructor(private route: ActivatedRoute,
      private service: ClientService) { }

    ngOnInit(): void {
      // Set sample data for supplier invoices
      let  data : string =  this.route.snapshot.queryParamMap.get('userData') || "";
      console.log(JSON.parse(data));
      console.log(this.username);

      this.supplierCode = "SUP1234";
      this.invoiceNumber = "INV5678";
      this.invoiceDate = new Date();
      this.invoiceAmount = 1000;
      this.currency = "USD";
      this.invoiceStatus = "Paid";
    }

  }

