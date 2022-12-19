import { Component, OnInit } from '@angular/core';
import { BookingServiceService } from 'src/app/Utilities/APIServices/booking-service.service';
import { EventServiceService } from 'src/app/Utilities/APIServices/event-service.service';
import { UserServiceService } from 'src/app/Utilities/APIServices/user-service.service';
import { Booking } from 'src/app/Utilities/Model/Booking';
import { User } from 'src/app/Utilities/Model/User';
import { Event } from 'src/app/Utilities/Model/Event';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-show-events',
  templateUrl: './user-show-events.component.html',
  styleUrls: ['./user-show-events.component.scss']
})
export class UserShowEventsComponent implements OnInit {

  eventsList: Array<Event> = [];
  eventToBeSearched:string="";
  isEventBooke:any;
  user:User=new User();

  constructor(private _event_api_service:EventServiceService, private _booking_api_service:BookingServiceService,
    private _user_api_service:UserServiceService, private _router:Router) { 
  
  // sessionStorage.setItem("email",this.user.email);
  
  // sessionStorage.setItem("role",this.user.role);

   }

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="user") this._router.navigate(["/page_not_found"]);
    this._event_api_service.getAllEvents().subscribe(response => this.eventsList=response);
    this._user_api_service.getUserByEmail(sessionStorage.getItem("email")).subscribe(response => this.user=response);}


  bookEvent(event:Event){
    
    let booking:Booking = new Booking();
    console.log("line 38",this.user.userId);
      
    booking.user = this.user;
    booking.event = event;

    this._booking_api_service.getBookingByEventAndUser(event.eventId, this.user.userId).subscribe(
        response => {if(response) alert("event is already booked")
      else  alert("Event is booked");});
    this._booking_api_service.addBooking(booking).subscribe(response => console.log(response));
    
    
    }
    
    // isEventBooked(event_id:number, user_id:number):boolean{
    // let isEventBooked:any;  
    // let resp:any;
    // this._booking_api_service.getBookingByEventAndUser(event_id,user_id).subscribe(
    //   response => {isEventBooked=response;console.log("booked"+response);resp=response;
    //   console.log("inside type response =>",typeof response);
    //   console.log("resp => "+resp+" response => "+response);
    //   console.log("inside type res =>",typeof resp);
    //   isEventBooked = response;
    //   this.isEventBooke = response;
    // } 
      
      
    //   );
    // console.log("isEventBooked "+isEventBooked);
    // console.log("type",typeof resp);
    // console.log("resp =>"+resp);
    // return isEventBooked;
    // }
    
    getEventList(){
      // 
    }



}
