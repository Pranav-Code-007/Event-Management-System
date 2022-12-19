import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { EventServiceService } from 'src/app/Utilities/APIServices/event-service.service';

@Component({
  selector: 'app-edit-event',
  templateUrl: './edit-event.component.html',
  styleUrls: ['./edit-event.component.scss']
})
export class EditEventComponent implements OnInit {

  constructor(private _fb:FormBuilder,private _router:Router,private _activatedRoute:ActivatedRoute,private _eventService:EventServiceService) { }
  
  id:any;
  event:any;

  ngOnInit(): void{

    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="organizer") this._router.navigate(["/page_not_found"]);

    this._activatedRoute.params.subscribe(params => {
      this.id=params['id'];})

      this.event = this._eventService.getEvent(this.id).subscribe((response:any) => (this.event = response));
    console.log(this.id);
    console.log(this.event);
  }

  editEventForm:FormGroup = this._fb.group({
    eventName:[''],
    eventCategory:[''],
    eventVenue:[''],
    eventDate:[''],
    eventTime:[''],
    eventPrice:[''],
    eventDescription:[''],

  })

  editEvent()
  {
    this._eventService.editEvent(this.editEventForm.value).subscribe((response: any) => {console.log(response)});
    setTimeout(() => {
      this._router.navigate(['/organizer_account_show_events']);
    }, 1000);
  }

}
