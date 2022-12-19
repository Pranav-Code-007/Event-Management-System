import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventServiceService } from 'src/app/Utilities/APIServices/event-service.service';

@Component({
  selector: 'app-all-event',
  templateUrl: './all-event.component.html',
  styleUrls: ['./all-event.component.scss']
})
export class AllEventComponent implements OnInit {

  events:any;
  constructor(private _router:Router, private _eventService:EventServiceService) { }

  ngOnInit(): void {

    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="organizer") this._router.navigate(["/page_not_found"]);
    this._eventService.getEventOrganizedByOrganizer(Number(sessionStorage.getItem("id"))).subscribe(data => {console.log(data);
    this.events = data;});
    
    }

    getEvent(eventId:number)
    {
      this._eventService.getEvent(eventId).subscribe(data => {console.log(data)});
      this._router.navigate(['/editEvent/'+eventId]);

    }
    
    deleteEvent(eventId:number)
    {
      this._eventService.deleteEvent(eventId).subscribe(data => {console.log(data)});
      location.reload();
    }

}
