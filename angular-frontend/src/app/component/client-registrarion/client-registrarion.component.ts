import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { ClientService } from 'src/app/service/ClientService.service';
import { UserDto } from 'src/app/infrastructure/models/UserDto.dto';

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

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private clientService: ClientService
        // private alertService: AlertService
    ) { }

    ngOnInit() {
        this.clientRegistrationForm = this.formBuilder.group({
            name: ['', Validators.required],
            email: ['', Validators.required, Validators.email],
            username: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(6)]]
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.clientRegistrationForm.controls; }

    onSubmit() {
      const payload = {
        name: this.clientRegistrationForm.controls.name.value,
        email: this.clientRegistrationForm.controls.email.value,
        username: this.clientRegistrationForm.controls.username.value,
        password: this.clientRegistrationForm.controls.password.value
      } as UserDto;
        this.submitted = true;
        this.clientService.create(payload);
        // reset alerts on submit
        // this.alertService.clear();

        // stop here if form is invalid
        if (this.clientRegistrationForm.invalid) {
            return;
        }

        this.loading = true;
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
