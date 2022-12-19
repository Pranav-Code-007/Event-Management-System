import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EventCategoryServiceService } from 'src/app/Utilities/APIServices/event-category-service.service';
import { EventCategory } from 'src/app/Utilities/Model/EventCategory';

@Component({
  selector: 'app-event-category',
  templateUrl: './event-category.component.html',
  styleUrls: ['./event-category.component.scss']
})
export class EventCategoryComponent implements OnInit {
  eventCategoryList:EventCategory[]=[];
  categoryForm:FormGroup= this._formBuilder.group({
    category:["",[Validators.required, Validators.pattern("[a-z0-1A-Z ]+")]]

    });
  constructor(private _formBuilder:FormBuilder, private _router:Router,private _event_category_service:EventCategoryServiceService) { 

   }

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="admin") this._router.navigate(["/page_not_found"]);

     this._event_category_service.getAllCategories().subscribe(resp => this.eventCategoryList=resp);
  }

  delete(category:string){
    this._event_category_service.deleteCategory(category).subscribe();
    alert("category deleted");
    location.reload();
  }

  addCategory(){
   this._event_category_service.addCategory(this.categoryForm.value["category"]).subscribe();
   location.reload();
  }

}
