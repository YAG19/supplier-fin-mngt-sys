import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { InvoiceDto } from 'src/app/infrastructure/models/InvoiceDto.dto';
import { FileUploadService } from 'src/app/service/FileUploadService.service';
import { InvoiceService } from 'src/app/service/InvoiceService.service';
import { NotificationServiceService } from 'src/app/service/NotificationService.service';

@Component({
  selector: 'app-invoice-upload',
  templateUrl: './invoice-upload.component.html',
  styleUrls: ['./invoice-upload.component.css']
})
export class InvoiceUploadComponent implements OnInit {
  public invoiceForm!: FormGroup;
  currencies = ['USD', 'GBP', 'Euro'];
  loading = false;
  submitted = false;
  file!: File;
  username!: string;

  constructor(
    private fb: FormBuilder,
    private invoiceService: InvoiceService,
    private notifyService: NotificationServiceService,
    private fileUploadService :FileUploadService,
    private route: ActivatedRoute
    ) {
    this.initForm();
  }
  ngOnInit(): void {
    let  data : string =  this.route.snapshot.paramMap.get('username') || "";
    this.username = data;
  }
  initForm() {
    this.invoiceForm = this.fb.group({
      supplierCode: [123455, Validators.required],
      invoiceNumber: [11, Validators.required],
      invoiceDate: ['', Validators.required],
      invoiceAmount: [1000, Validators.required],
      currency: ['', Validators.required],
      invoiceFile: [Validators.required]
    });
  }
  public onFileSelected(event : any){
     this.file = event?.target.files[0];
    }
    get f() { return this.invoiceForm.controls; }

  onSubmit() {
    if (this.invoiceForm.valid) {
      console.log('Form is valid and ready for submission!');
    } else {
      console.log('Form is invalid');
    }
    if(!this.file?.name){
      this.notifyService.showWarning("Please Upload A file!","")
      return;
    }
    if(!this.username){
      this.notifyService.showWarning("Something Went Wrong please Login Again","")
      return;
    }
    const data = {
        currency: this.invoiceForm.controls.currency.value,
        invoiceAmount:this.invoiceForm.controls.invoiceAmount.value,
        invoiceDate: this.invoiceForm.controls.invoiceDate.value,
        invoiceNumber: this.invoiceForm.controls.invoiceNumber.value,
        supplierCode: this.invoiceForm.controls.supplierCode.value,
        username: this.username
    } as InvoiceDto;

    this.loading = true;
      // this.invoiceService.invoiceUpload(data, this.file).subscribe(
      //    {
      //     complete : (data: any) => { this.notifyService.showSuccess("Successfully Uploaded Invoice", "");this.loading = false; },
      //     error:
      //         (error : any) => { this.notifyService.showError
      //             console.log(error);
      //             const errorMsg = error?.error?.message;
      //             this.notifyService.showWarning(errorMsg, "")
      //             this.loading = false;
      //         }
      //       })

      this.invoiceService.invoiceUpload(data, this.file).subscribe(
        {
          next: (data) => {
            this.notifyService.showSuccess("Successfully Uploaded Invoice","")
          },
          error: (err: any) => {
                        console.log(err);
                        const errorMsg = err?.error?.message;
                        this.notifyService.showWarning(errorMsg, "")
                        this.loading = false;
          },
          complete: () => { }
        }
      );
    }
}
