import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EventCategory } from '../Model/EventCategory';

@Injectable({
  providedIn: 'root'
})
export class EventCategoryServiceService {

  constructor(private _httpClient:HttpClient) { }
  BASE_URL:string="http://localhost:8089/category";

  getAllCategories():Observable<EventCategory[]>{
    return this._httpClient.get<EventCategory[]>(this.BASE_URL+"/getall");
  }

  deleteCategory(category:string):Observable<string>{
    return this._httpClient.delete<string>(this.BASE_URL+"/delete/"+category);
  }

  updateCategory(category:string, updateCategory:string):Observable<string>{
    return this._httpClient.put<string>(this.BASE_URL+"/update/"+category+"/"+updateCategory,null);
  }

  addCategory(category:string):Observable<string>{
    return this._httpClient.post<string>(this.BASE_URL+"/add/"+category,null);
  }


}
