import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingServiceService } from 'src/app/Utilities/APIServices/booking-service.service';
import { Booking } from 'src/app/Utilities/Model/Booking';

@Component({
  selector: 'app-all-booking',
  templateUrl: './all-booking.component.html',
  styleUrls: ['./all-booking.component.scss']
})
export class AllBookingComponent implements OnInit {

  bookingList:Booking[]=[]

  constructor(private _booking_service: BookingServiceService, private _router:Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="admin") this._router.navigate(["/page_not_found"]);
    this._booking_service.getAllBookings().subscribe(response => this.bookingList=response);
  }

  setStatusPending(id:number){
    this._booking_service.setBookingStatus(id,"pending").subscribe(response => console.log(response));
  location.reload()
  }

  setStatusApproved(id:number){
    this._booking_service.setBookingStatus(id,"approved").subscribe(response => console.log(response));
    location.reload() 
  }

}
