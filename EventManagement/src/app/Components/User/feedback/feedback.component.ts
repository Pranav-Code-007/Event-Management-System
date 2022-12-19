import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FeedbackServiceService } from 'src/app/Utilities/APIServices/feedback-service.service';
import { Feedback } from 'src/app/Utilities/Model/Feedback';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {

  feedback:Feedback = new Feedback();

  feedbackForm:FormGroup= this._formBuilder.group({
    feedback:["",[Validators.required]],
    rating:["",[Validators.required]]

    });

  constructor(private _formBuilder:FormBuilder, private _feedback_service:FeedbackServiceService, private _router:Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="user") this._router.navigate(["/page_not_found"]);

  }

  submitFeedback():void{

    this.feedback.feedback = this.feedbackForm.value["feedback"];
    this.feedback.rating = Number(this.feedbackForm.value["rating"]);
    this.feedback.userId = Number(sessionStorage.getItem("id"));
 
    this._feedback_service.addFeedback(this.feedback).subscribe();

    this._router.navigate(["/user_account_show_events"]);

  }

}
