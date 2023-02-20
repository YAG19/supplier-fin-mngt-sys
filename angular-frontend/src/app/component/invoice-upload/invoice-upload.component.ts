import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-invoice-upload',
  templateUrl: './invoice-upload.component.html',
  styleUrls: ['./invoice-upload.component.css']
})
export class InvoiceUploadComponent {
  public invoiceForm!: FormGroup;
  currencies = ['USD', 'GBP', 'Euro'];

  constructor(private fb: FormBuilder) {
    this.initForm();
  }
  initForm() {
    this.invoiceForm = this.fb.group({
      supplierCode: ['', Validators.required],
      invoiceNumber: ['', Validators.required],
      invoiceDate: ['', Validators.required],
      invoiceAmount: ['', Validators.required],
      currency: ['', Validators.required],
      invoiceFile: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.invoiceForm.valid) {
      // TODO: Implement form submission logic here
      console.log('Form is valid and ready for submission!');
    } else {
      console.log('Form is invalid');
    }
  }
}
