import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/Utilities/APIServices/user-service.service';
import { User } from 'src/app/Utilities/Model/User';

@Component({
  selector: 'app-organizer-list',
  templateUrl: './organizer-list.component.html',
  styleUrls: ['./organizer-list.component.scss']
})
export class OrganizerListComponent implements OnInit {

  organizerList: Array<User> = [];
  organizerToBeSearched:string="";

  constructor(private _organizer_service:UserServiceService,private _router:Router) {
    
   }

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="admin") this._router.navigate(["/page_not_found"]);

this._organizer_service.getAllUserByRole("organizer").subscribe((organizer) => this.organizerList=organizer);

  }

  delete(organizerId:number){
    this._organizer_service.deleteUserById(organizerId).subscribe((deleted) => console.log("deleted "+deleted));
    location.reload();
  }

  edit(organizerId:number){
    this._router.navigate(["/admin_organizer_update/"+organizerId])
  }

}
