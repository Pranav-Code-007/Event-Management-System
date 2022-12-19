import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/Utilities/APIServices/user-service.service';
import { User } from 'src/app/Utilities/Model/User';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  userList: Array<User> = [];
  userToBeSearched:string="";

  constructor(private _user_service:UserServiceService,private _router:Router) { }

 

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="admin") this._router.navigate(["/page_not_found"]);

this._user_service.getAllUserByRole("user").subscribe(user => this.userList=user);

  }

  delete(userId:number){
    this._user_service.deleteUserById(userId).subscribe(deleted => console.log("deleted "+deleted));
    location.reload();
  }

  edit(userId:number){
    this._router.navigate(["/admin_user_update/"+userId]);
  }

}
