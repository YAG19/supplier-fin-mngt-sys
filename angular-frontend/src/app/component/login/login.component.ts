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

    get form() { return this.ClientLoginForm.controls; }

    onSubmit() {
        this.submitted = true;

        if (this.ClientLoginForm.invalid) {
            return;
        }

        this.loading = true;
        this.clientService.login(this.form.username.value, this.form.password.value)
            .pipe(first())
            .subscribe({
                next: (data) => {
                  console.log(data);
                  if(data?.username){
                    this.notifyService.showSuccess("Login successful!","")
                    console.log(data)
                    let dataToSend = JSON.stringify(data)
                    this.router.navigate(['/invoice'], { queryParams: { userData: dataToSend } });
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
