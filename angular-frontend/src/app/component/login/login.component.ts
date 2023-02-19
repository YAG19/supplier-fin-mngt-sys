import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { ClientService } from 'src/app/service/ClientService.service';
import { NotificationServiceService } from 'src/app/service/NotificationService.service';

// import { AccountService, AlertService } from '@app/_services';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    ClientLoginForm!: FormGroup;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private clientService: ClientService,
        private notifyService: NotificationServiceService
    ) { }

    ngOnInit() {
        this.ClientLoginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.ClientLoginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // reset alerts on submit
        // this.alertService.clear();

        // stop here if form is invalid
        if (this.ClientLoginForm.invalid) {
            return;
        }

        this.loading = true;
        this.clientService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe({
                next: (data) => {
                  if(data?.loanAccNumber){
                    this.notifyService.showSuccess("Login successful!","")
                  }
                  else{
                    this.notifyService.showError("Invalid Password","");
                    this.loading = false;
                  }

                },
                error: error => {
                    console.log(error);
                    const errMsg: string = error?.error?.message;
                    this.notifyService.showError(errMsg,"")
                    this.loading = false;
                }
            });
    }
}
