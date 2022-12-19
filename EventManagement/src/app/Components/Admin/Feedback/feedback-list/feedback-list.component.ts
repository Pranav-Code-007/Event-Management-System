import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FeedbackServiceService } from 'src/app/Utilities/APIServices/feedback-service.service';
import { Feedback } from 'src/app/Utilities/Model/Feedback';

@Component({
  selector: 'app-feedback-list',
  templateUrl: './feedback-list.component.html',
  styleUrls: ['./feedback-list.component.scss']
})
export class FeedbackListComponent implements OnInit {

  feedbackListt:Feedback[]=[];

  constructor(private _feedback_service:FeedbackServiceService, private _router:Router) {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="admin") this._router.navigate(["/page_not_found"]);

   }

  ngOnInit(): void {
    this._feedback_service.getAllFeedback().subscribe(response => this.feedbackListt=response);
  }

}
