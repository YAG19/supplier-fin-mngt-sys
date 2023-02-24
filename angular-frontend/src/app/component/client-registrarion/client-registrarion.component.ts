import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { ClientService } from 'src/app/service/ClientService.service';
import { UserDto } from 'src/app/infrastructure/models/UserDto.dto';
import { NotificationServiceService } from 'src/app/service/NotificationService.service';

// import { AccountService, AlertService } from '@app/_services';

@Component({
  selector: 'app-client-registrarion',
  templateUrl: './client-registrarion.component.html',
  styleUrls: ['./client-registrarion.component.css']
})
export class ClientRegistrarionComponent implements OnInit {

    clientRegistrationForm!: FormGroup;
    loading = false;
    submitted = false;
    public countryList = ["India","Australia","United States"];
    public cityList = ["Ahemdabad","Banglore","Mumbai","Sydney"];
    public stateList = ["Gujarat","Karnataka","Maharastra"];

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private clientService: ClientService,
        private notifyService: NotificationServiceService
    ) { }

    ngOnInit() {
        this.clientRegistrationForm = this.formBuilder.group({
            name: ['yagnesh', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
            address: ['Room no 101, xyz society'],
            city:[''],
            state:[],
            country:[],
            email: ['yagnesh@gmail.com', [Validators.required, Validators.email, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
            mobNumber: ['', [Validators.minLength(10), Validators.maxLength(10)]],
            loanAccNumber: [123456, Validators.required],
            loanInfo: ['Home', Validators.required],
            username: ['yagnesh1234', Validators.required],
            password: ['yagnesh1234', [Validators.required, Validators.minLength(6)]]
        });
    }

    get f() { return this.clientRegistrationForm.controls; }

    onSubmit() {
      const address = this.clientRegistrationForm.controls.address.value + ' City: ' + this.clientRegistrationForm.controls.city.value + ' State: ' + this.clientRegistrationForm.controls.state.value + ' Country: ' + this.clientRegistrationForm.controls.country.value
      const payload = {
        name: this.clientRegistrationForm.controls.name.value,
        email: this.clientRegistrationForm.controls.email.value,
        username: this.clientRegistrationForm.controls.username.value,
        password: this.clientRegistrationForm.controls.password.value,
        address:address,
        mobileNumber: this.clientRegistrationForm.controls.mobNumber.value,
        loanAccNumber: this.clientRegistrationForm.controls.loanAccNumber.value,
        loanInfo: this.clientRegistrationForm.controls.loanInfo.value
      } as UserDto;
        this.submitted = true;
        if (this.clientRegistrationForm.invalid) {
          return;
      }

      this.loading = true;
      console.log(payload);
        this.clientService.create(payload).subscribe(
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
