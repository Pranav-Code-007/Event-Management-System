import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/Utilities/APIServices/user-service.service';
import { User } from 'src/app/Utilities/Model/User';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor( private _formBuilder:FormBuilder, private _user_service:UserServiceService, private _router:Router) {}

  user:User=new User();

  registerForm:FormGroup= this._formBuilder.group({
  name:["",Validators.required],
  email:["",[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
  password:["",[Validators.required,Validators.minLength(8)]],
  confirm_password:["",[Validators.required]],
  mobile_number:["",Validators.required],
  role:["",Validators.required]
  },{validator: ConfirmedValidator('password', 'confirm_password')});


  ngOnInit(): void {
  }

  register(){

    this.user.name = this.registerForm.value["name"];
    this.user.email = this.registerForm.value["email"];
    this.user.password = this.registerForm.value["password"];
    this.user.mobile_number = this.registerForm.value["mobile_number"];
    this.user.role = this.registerForm.value["role"];
    console.log("role => " + this.registerForm.value["role"]);
    this._user_service.addUser(this.user).subscribe(response => {alert(response);
    
    if(response=="registered successfully"){
      
        this._router.navigate(["/login"]);
    }
    else{
      
    }
    
    }); 
   


  }

}
function ConfirmedValidator(controlName: string, matchingControlName: string): any {
  return (formGroup: FormGroup) => {

    const control = formGroup.controls[controlName];

    const matchingControl = formGroup.controls[matchingControlName];

    if (matchingControl.errors && !matchingControl.errors['confirmedValidator']) {

        return;

    }

    if (control.value !== matchingControl.value) {

        matchingControl.setErrors({ confirmedValidator: true });

    } else {

        matchingControl.setErrors(null);

    }

}
}

