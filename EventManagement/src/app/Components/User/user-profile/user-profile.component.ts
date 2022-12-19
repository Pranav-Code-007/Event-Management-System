import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/Utilities/APIServices/user-service.service';
import { User } from 'src/app/Utilities/Model/User';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  user:User=new User();
  constructor(private _user_service:UserServiceService, private _formBuilder:FormBuilder, private _router:Router) { 
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="user") this._router.navigate(["/page_not_found"]);
    
   }

   
  
   userForm:FormGroup= this._formBuilder.group({
     name:[this.user.name,Validators.required],
     email:[this.user.email,Validators.required],
     password:[this.user.password,Validators.required],
     mobile_number:[this.user.mobile_number,Validators.required]
     });

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="user") this._router.navigate(["/page_not_found"]);
    console.log("id =>"+sessionStorage.getItem("id"));
    this._user_service.getUserById(Number(sessionStorage.getItem("id"))).subscribe(response => {this.user=response; console.log("response =>",response) });

  }
  update(){
    console.log("update aalo");
    console.log(this.user.userId);
    console.log(this.userForm.value["name"]);
    console.log(this.userForm.value["email"]);
    console.log(this.userForm.value["password"]);
    console.log(this.userForm.value["mobile_number"]);
   
    this.user.name = this.userForm.value["name"];
    this.user.email = this.userForm.value["email"];
    this.user.password = this.userForm.value["password"];
    this.user.mobile_number = Number(this.userForm.value["mobile_number"]);
    
   this._user_service.updateUser(this.user.userId,this.user).subscribe(resp => console.log(resp));
  
   alert("profile updated");
   setTimeout(()=>this._router.navigate(['/user_account_show_events']),50);
   }
}
