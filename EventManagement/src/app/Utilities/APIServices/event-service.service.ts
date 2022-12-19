import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Event } from '../Model/Event';
@Injectable({
  providedIn: 'root'
})
export class EventServiceService {

  constructor(private _httpClient:HttpClient) { }
  BASE_URL:string="http://localhost:8089/event";

  getAllEvents():Observable<Event[]>{
    return this._httpClient.get<Event[]>(this.BASE_URL+"/getAllEvents");
  }

  addEvent(event:any) {
    return this._httpClient.post(this.BASE_URL+"/addEvent",event,{responseType:'JSON' as 'text'});
  }

  getEvent(eventId:number)
  {
    return this._httpClient.get(this.BASE_URL+"/getEvent/"+eventId,{responseType: 'JSON' as 'text'});
  }

  editEvent(eventId:number){
    return this._httpClient.put(this.BASE_URL+"/updateEvent/"+eventId,{responseType: 'JSON' as 'text'});
  }

  deleteEvent(eventId:number)
  {
    return this._httpClient.delete(this.BASE_URL+"/deleteEvent/"+eventId,{responseType: 'JSON' as 'text'});
  }

  getEventOrganizedByOrganizer(organizerId:Number){
    return this._httpClient.get(this.BASE_URL+"/getUserById/"+organizerId);
  }

}
