import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { UserDto } from 'src/app/infrastructure/models/UserDto.dto';
import { NotificationServiceService } from 'src/app/service/NotificationService.service';
import { SupplierService } from 'src/app/service/SupplierService.service';
import { SupplierDto } from 'src/app/infrastructure/models/SupplierDto.dto';

// import { AccountService, AlertService } from '@app/_services';

@Component({
  selector: 'app-supplier-registration',
  templateUrl: './supplier-registration.component.html',
  styleUrls: ['./supplier-registration.component.css']
})
export class SupplierRegistrationComponent implements OnInit {
    supplierRegistrationForm!: FormGroup;
    loading = false;
    submitted = false;
    public countryList = ["India","Australia","United States"];
    public cityList = ["Ahemdabad","Banglore","Mumbai","Sydney"];
    public stateList = ["Gujarat","Karnataka","Maharastra"];

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private supplierService: SupplierService,
        private notifyService: NotificationServiceService
    ) { }

    ngOnInit() {
        this.supplierRegistrationForm = this.formBuilder.group({
            name: ['yagnesh', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
            address: [''],
            city:[''],
            state:[],
            country:[],
            email: ['yagnesh@gmail.com', [Validators.required, Validators.email, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
            mobNumber: ['', [Validators.minLength(10), Validators.maxLength(10)]],
            creditAccNumber: ['123456', Validators.required],
            creditInfo: ['asdad', Validators.required],
            username: ['yagnesh1234', Validators.required],
            password: ['yagnesh1234', [Validators.required, Validators.minLength(6)]]
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.supplierRegistrationForm.controls; }

    onSubmit() {
      const address = this.supplierRegistrationForm.controls.address.value + ' City: ' + this.supplierRegistrationForm.controls.city.value + ' State: ' + this.supplierRegistrationForm.controls.state.value + ' Country: ' + this.supplierRegistrationForm.controls.country.value
      const payload = {
        supplierName: this.supplierRegistrationForm.controls.name.value,
        supplierEmail: this.supplierRegistrationForm.controls.email.value,
        username: this.supplierRegistrationForm.controls.username.value,
        password: this.supplierRegistrationForm.controls.password.value,
        supplierAddress:address,
        suppliermobnumber: this.supplierRegistrationForm.controls.mobNumber.value,
        creditAccNumber: this.supplierRegistrationForm.controls.creditAccNumber.value,
        creditInfo: this.supplierRegistrationForm.controls.creditInfo.value
      } as SupplierDto;

        this.submitted = true;
        if (this.supplierRegistrationForm.invalid) {
          return;
      }

      this.loading = true;
      console.log(payload);
        this.supplierService.create(payload).subscribe(
          (data) => {
            console.log(data);
              if(data){
                this.notifyService.showSuccess("Successfully Registerd", "");

                this.router.navigate(['/login']);
              }
          }
          ,
          (error) =>{
            console.log(error);
            const errorMsg = error?.error?.message;
            this.notifyService.showWarning(errorMsg, "")
            this.loading = false;

         }
        );
        // reset alerts on submit
        // this.alertService.clear();

        // stop here if form is invalid
        // this.accountService.register(this.form.value)
            // .pipe(first())
            // .subscribe({
            //     next: () => {
            //         this.alertService.success('Registration successful', { keepAfterRouteChange: true });
            //         this.router.navigate(['../login'], { relativeTo: this.route });
            //     },
            //     error: error => {
            //         this.alertService.error(error);
            //         this.loading = false;
            //     }
            // });
    }
}

