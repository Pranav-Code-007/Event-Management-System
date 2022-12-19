import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EventCategoryServiceService } from 'src/app/Utilities/APIServices/event-category-service.service';
import { EventCategory } from 'src/app/Utilities/Model/EventCategory';

@Component({
  selector: 'app-event-category-update',
  templateUrl: './event-category-update.component.html',
  styleUrls: ['./event-category-update.component.scss']
})
export class EventCategoryUpdateComponent implements OnInit {
  category:string="";
  last_category:string="";
  categoryForm:FormGroup= this._formBuilder.group({
    event_category:[this.category,[Validators.required, Validators.pattern("[a-z0-1A-Z ]+")]]

    });
  constructor(private _event_category_service:EventCategoryServiceService, private _formBuilder:FormBuilder, private _router:Router, private _activated_route:ActivatedRoute) { }
  
  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="admin") this._router.navigate(["/page_not_found"]);

    this._activated_route.params.subscribe(params =>{this.category = params["category"];
    this.last_category = this.category;
    alert(params["category"]);});
  }
  
  updateCategory(){
  this._event_category_service.updateCategory(this.last_category,this.category).subscribe();
   this._router.navigate(["/event_category"]);
  }

}
