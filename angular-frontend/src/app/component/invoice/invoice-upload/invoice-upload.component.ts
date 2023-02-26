import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { InvoiceDto } from 'src/app/infrastructure/models/InvoiceDto.dto';
import { InvoiceService } from 'src/app/service/InvoiceService.service';
import { NotificationServiceService } from 'src/app/service/NotificationService.service';

@Component({
  selector: 'app-invoice-upload',
  templateUrl: './invoice-upload.component.html',
  styleUrls: ['./invoice-upload.component.css'],
})
export class InvoiceUploadComponent implements OnInit {
  invoiceForm!: FormGroup;
  currencies = ['USD', 'GBP', 'Euro'];
  loading = false;
  submitted = false;
  file!: File;
  username!: string;
  role!: string;

  constructor(
    private fb: FormBuilder,
    private invoiceService: InvoiceService,
    private notifyService: NotificationServiceService,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.initForm();
    let data: string = this.route.snapshot.paramMap.get('username') || '';
    this.username = data;
    let role: string = this.route.snapshot.paramMap.get('role') || '';
    this.role = role;
    console.log(this.role,this.username);

  }
  get f() {
    return this.invoiceForm.controls;
  }
  initForm() {
    this.invoiceForm = this.fb.group({
      supplierCode: [1003, [Validators.required]],
      invoiceNumber: [11, [Validators.required]],
      invoiceDate: ['', [Validators.required]],
      invoiceAmount: [1000, [Validators.required]],
      currency: ['', [Validators.required]],
      invoiceFile: [[Validators.required]],
    });
  }
  public onFileSelected(event: any) {
    this.file = event?.target.files[0];
  }


  onSubmit() {
    this.submitted = true;
    if (this.invoiceForm.valid) {
      console.log('Form is valid and ready for submission!');
    } else {
      console.log('Form is invalid');
      return;
    }
    if (!this.file?.name) {
      this.notifyService.showWarning('Please Upload A file!', '');
      return;
    }else{
      if(this.file.size > 1000000)
      {
        this.notifyService.showWarning("File Size exceeds","")
        return;
      }
    }
    if (!this.username) {
      this.notifyService.showWarning(
        'Something Went Wrong please Login Again',
        ''
      );
      return;
    }
    const data = {
      currency: this.invoiceForm.controls.currency.value,
      invoiceAmount: this.invoiceForm.controls.invoiceAmount.value,
      invoiceDate: this.invoiceForm.controls.invoiceDate.value,
      invoiceNumber: this.invoiceForm.controls.invoiceNumber.value,
      supplierCode: this.invoiceForm.controls.supplierCode.value,
      username: this.username,
    } as InvoiceDto;

    this.loading = true;

console.log(data);
    this.invoiceService.invoiceUpload(data, this.file).subscribe({
      next: (data) => {
        console.log(data);
        if(data?.body?.message){
        let successMsg = data?.body?.message;
        this.notifyService.showSuccess('Invoice', successMsg);}
      },
      error: (err: any) => {
        console.log(err);
        const errorMsg = err?.error?.message;
        errorMsg ? this.notifyService.showWarning(errorMsg, '') : this.notifyService.showError("Error Occured while Uploading Invoice", errorMsg);
        this.loading = false;
      },
      complete: () => {
        this.loading = false;
      },
    });
  }
}
