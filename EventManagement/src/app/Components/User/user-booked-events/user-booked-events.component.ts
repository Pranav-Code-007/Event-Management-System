import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingServiceService } from 'src/app/Utilities/APIServices/booking-service.service';
import { Booking } from 'src/app/Utilities/Model/Booking';

@Component({
  selector: 'app-user-booked-events',
  templateUrl: './user-booked-events.component.html',
  styleUrls: ['./user-booked-events.component.scss']
})
export class UserBookedEventsComponent implements OnInit {

  bookedEventList:Event[]=[];
  statusList:string[]=[];
  bookingList:Booking[]=[];
  constructor(private _router:Router,private _booking_api_service:BookingServiceService) {

   }

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="user") this._router.navigate(["/page_not_found"]);
     this._booking_api_service.getBookedEventsByUser(Number(sessionStorage.getItem("id"))).subscribe(response => {this.bookingList = response; console.log(response);} );
     setTimeout(()=>console.log("after timeout"),100);
     
    //  this._booking_api_service.getBookedEventsByUser(Number(sessionStorage.getItem("id"))).subscribe(response => {this.bookingList = response; console.log(response);} );

     console.log("id",sessionStorage.getItem("id"));
     console.log(this.bookingList);
    
    }

    cancelBooking(bookingId:number){
     alert("ala ka bhava");
     this._booking_api_service.deleteBookingById(bookingId).subscribe();
     location.reload(); 
    }
}
