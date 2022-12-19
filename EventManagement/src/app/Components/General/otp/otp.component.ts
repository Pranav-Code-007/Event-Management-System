import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/Utilities/APIServices/user-service.service';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.scss']
})
export class OtpComponent implements OnInit {

  constructor(private _formBuilder: FormBuilder, private _user_service: UserServiceService, private _router: Router) { }

  otpForm: FormGroup = this._formBuilder.group({
    one: ["", Validators.required],
    two: ["", Validators.required],
    three: ["", Validators.required],
    four: ["", Validators.required],
    five: ["", Validators.required]

  });

  ngOnInit(): void {
  }

  submitOTP() {

    sessionStorage.setItem("login", "true");
   
    let otp: string = this.otpForm.value["one"] + this.otpForm.value["two"] + this.otpForm.value["three"] + this.otpForm.value["four"] + this.otpForm.value["five"];
    let email: string | any = sessionStorage.getItem("email");
    this._user_service.verifyOtp(email, otp).subscribe(response => {

      if (response == "login with otp successfull") {

         this._user_service.getUserByEmail(email).subscribe(resp => sessionStorage.setItem("id",String(resp.userId)));
        sessionStorage.setItem("login","true");
        if (sessionStorage.getItem("role") == "user")
          this._router.navigate(["/user_account_show_events"]);

        else if (sessionStorage.getItem("role") == "organizer")
          this._router.navigate(["/organizer_account_show_events"]);

        else if (sessionStorage.getItem("role") == "admin")
          this._router.navigate(["/admin_dashboard"]);

        else {
          this._router.navigate(["/page_not_found"]);
        }
      }
      else {
        alert(response);
      }


    });
  }

}
