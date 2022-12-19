import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from 'src/app/Utilities/APIServices/user-service.service';
import { User } from 'src/app/Utilities/Model/User';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.scss']
})
export class UpdateUserComponent implements OnInit {

  user:User=new User();
  
  userForm:FormGroup= this._formBuilder.group({
    name:[this.user.name,Validators.required],
    email:[this.user.email,Validators.required],
    password:[this.user.password,Validators.required],
    mobile_number:[this.user.mobile_number,Validators.required]

    });


    
  constructor(private _user_service:UserServiceService,private _activated_route:ActivatedRoute, private _formBuilder:FormBuilder, private _router:Router) {

   }

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="admin") this._router.navigate(["/page_not_found"]);

    this._activated_route.params.subscribe(params => this._user_service.getUserById(params["id"]).subscribe(user=>this.user=user));
  }

  update(){

    this.user.name = this.userForm.value["name"];
    this.user.email = this.userForm.value["email"];
    this.user.password = this.userForm.value["password"];
    this.user.mobile_number = Number(this.userForm.value["mobile_number"]);
    
   this._user_service.updateUser(this.user.userId,this.user).subscribe(resp => console.log(resp));
  
   alert("profile updated");
   setTimeout(()=>this._router.navigate(['/admin_user_list']),50);

  }

  setStatus(status:number){
  this.user.status=status;
  alert(this.user.userId);
  }
  
}
