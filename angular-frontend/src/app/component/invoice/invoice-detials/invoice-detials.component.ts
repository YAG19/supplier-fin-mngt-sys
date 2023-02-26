import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InvoiceDto } from 'src/app/infrastructure/models/InvoiceDto.dto';
import { InvoiceService } from 'src/app/service/InvoiceService.service';
import { NotificationServiceService } from 'src/app/service/NotificationService.service';
@Component({
  selector: 'app-invoice-detials',
  templateUrl: './invoice-detials.component.html',
  styleUrls: ['./invoice-detials.component.css'],
})
export class InvoiceDetialsComponent implements OnInit {
  supplierCode: string | undefined;
  invoiceNumber: string | undefined;
  invoiceDate: Date | undefined;
  invoiceAmount: number | undefined;
  currency: string | undefined;
  invoiceStatus: string | undefined;
  data!: string | null;
  username: any;
  id: any;
  role: any;
  public invoiceList!: InvoiceDto[];
  noData: boolean = false;
  constructor(
    private route: ActivatedRoute,
    private invoiceService: InvoiceService,
    private notifyService: NotificationServiceService
  ) {}

  ngOnInit(): void {
    let data: string = this.route.snapshot.paramMap.get('username') || '';
    this.username = data;
    let role: string = this.route.snapshot.paramMap.get('role') || '';
    this.role = role;
    if (this.role === 'CLIENT') {
      this.invoiceService.getInvoiceDetails(this.username).subscribe({
        next: (data) => {
          this.invoiceList = data;
          if (this.invoiceList.length === 0) {
            this.noData = true;
            console.log(this.noData);
          }
        },
        error: (err: any) => {
          console.log(err);
          const errorMsg = err?.error?.message;
          errorMsg ? this.notifyService.showWarning(errorMsg, '') : this.notifyService.showWarning( 'Error occurred', 'Please Login to continue');
        }
      });
    }
    else
    {
      this.invoiceService.getAllInvoiceDetials().subscribe({
        next: (data) => {
          this.invoiceList = data;
        },
        error: (err: any) => {
          const errorMsg = err?.error?.message;
          errorMsg ? this.notifyService.showWarning(errorMsg, 'Error') : this.notifyService.showWarning('Error occurred','Please Login to continue');
        }
      }
      );
    }
  }
}
