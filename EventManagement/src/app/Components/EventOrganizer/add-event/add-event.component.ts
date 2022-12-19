import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { EventServiceService } from 'src/app/Utilities/APIServices/event-service.service';
import { UserServiceService } from 'src/app/Utilities/APIServices/user-service.service';
import { Event } from 'src/app/Utilities/Model/Event';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.scss']
})
export class AddEventComponent implements OnInit {

  event:Event=new Event();
  message: any;
  error: any;
  user: any;
  constructor(private _route:Router, private _fb:FormBuilder, private _eventService:EventServiceService, private _userService:UserServiceService,private _router:Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="organizer") this._router.navigate(["/page_not_found"]);
   
     this._userService.getUserById(Number(sessionStorage.getItem('id'))).subscribe(resp => {this.user = resp; console.log(this.user) }); 

  }
 addeventForm:FormGroup= this._fb.group({
  eventName:[''],
  eventCategory:[''],
  eventVenue:[''],
  eventDate:[''],
  eventTime:[''],
  eventPrice:[''],
  eventDescription:[''],
});


addEvent()
{
 
  

  this.event.user = this.user;
  console.log(this.addeventForm.value);
  // this.user.email = this.addeventForm.value["email"];
  // this.user.password = this.addeventForm.value["password"];
  // this.user.role = this.addeventForm.value["role"]; 
  
  this.event.name = this.addeventForm.value["eventName"];
  this.event.category = this.addeventForm.value["eventCategory"];
  this.event.venue = this.addeventForm.value["eventVenue"];
  this.event.date = this.addeventForm.value["eventDate"];
  this.event.time = this.addeventForm.value["eventTime"];
  this.event.price = Number(this.addeventForm.value["eventPrice"]);
  this.event.description = this.addeventForm.value["eventDescription"];


  console.log("email"+this.user.name);
  console.log("email"+this.user.email);
  console.log("email"+this.user.password);
  console.log("email"+this.user.role);
  
  this._eventService.addEvent(this.event).subscribe(response => {this.error =response; console.log(response)});
  setTimeout(() => {
    this._route.navigate(["/organizer_account_show_events"]);
},1000);

}


}
