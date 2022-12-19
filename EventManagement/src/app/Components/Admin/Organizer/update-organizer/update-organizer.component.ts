import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from 'src/app/Utilities/APIServices/user-service.service';
import { User } from 'src/app/Utilities/Model/User';

@Component({
  selector: 'app-update-organizer',
  templateUrl: './update-organizer.component.html',
  styleUrls: ['./update-organizer.component.scss']
})
export class UpdateOrganizerComponent implements OnInit {

  organizer:User=new User();
  
  organizerForm:FormGroup= this._formBuilder.group({
    name:[this.organizer.name,Validators.required],
    email:[this.organizer.email,Validators.required],
    password:[this.organizer.password,Validators.required],
    mobile_number:[this.organizer.mobile_number,Validators.required]

    });


    
  constructor(private _organizer_service:UserServiceService,private _activated_route:ActivatedRoute, private _formBuilder:FormBuilder, private _router:Router) {

   }

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="admin") this._router.navigate(["/page_not_found"]);

    this._activated_route.params.subscribe(params => this._organizer_service.getUserById(params["id"]).subscribe(organizer=>this.organizer=organizer));
  }

  update(){

    this.organizer.name = this.organizerForm.value["name"];
    this.organizer.email = this.organizerForm.value["email"];
    this.organizer.password = this.organizerForm.value["password"];
    this.organizer.mobile_number = Number(this.organizerForm.value["mobile_number"]);
    
   this._organizer_service.updateUser(this.organizer.userId,this.organizer).subscribe(resp => console.log(resp));
  
   alert("profile updated");
   setTimeout(()=>this._router.navigate(['/admin_organizer_list']),50);

  }

  setStatus(status:number){
  this.organizer.status=status;
  alert(this.organizer.userId);
  }

}
