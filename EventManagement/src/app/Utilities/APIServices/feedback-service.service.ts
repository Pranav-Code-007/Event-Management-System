import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Feedback } from '../Model/Feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackServiceService {

  BASE_URL:string="http://localhost:8089/feedback/";
   
  constructor(private _httpClient:HttpClient) {  }

  addFeedback(feedback:Feedback):Observable<string>{
    return this._httpClient.post<string>(this.BASE_URL+"addfeedback",feedback);
  }

  getAllFeedback():Observable<Feedback[]>{
    return this._httpClient.get<Feedback[]>(this.BASE_URL+"getall");
  }
  

}
