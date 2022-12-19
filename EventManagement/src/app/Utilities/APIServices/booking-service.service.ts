import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../Model/Booking';

@Injectable({
  providedIn: 'root'
})
export class BookingServiceService {

  constructor(private _httpClient:HttpClient) { }
  BASE_URL:string="http://localhost:8089/booking";

  addBooking(booking:Booking):Observable<any>{
    return this._httpClient.post<any>(this.BASE_URL+"/addBooking",booking);
  }

  getBookingByEventAndUser(eventId:number, userId:number):Observable<any>{
    return this._httpClient.get<any>(this.BASE_URL+"/getEventAndUser/"+eventId+"/"+userId);
  }

  getBookedEventsByUser(userId:number):Observable<Booking[]>{
    return this._httpClient.get<Booking[]>(this.BASE_URL+"/user/"+userId);
  }

 deleteBookingById(bookingId:number){
  return this._httpClient.delete(this.BASE_URL+"/deleteBooking/"+bookingId);
 }

 getAllBookings():Observable<Booking[]>{
  return this._httpClient.get<Booking[]>(this.BASE_URL+"/getAll");
 }

 setBookingStatus(bookingId:number,status:string):Observable<string>{
  return this._httpClient.put<string>(this.BASE_URL+"/updateBookingStatus/"+bookingId+"/"+status,null)
 }


}
