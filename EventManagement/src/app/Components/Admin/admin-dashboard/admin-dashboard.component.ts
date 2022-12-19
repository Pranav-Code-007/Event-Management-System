import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss']
})
export class AdminDashboardComponent implements OnInit {

  constructor(private _router:Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("login") == null || sessionStorage.getItem("role")!="admin") this._router.navigate(["/page_not_found"]);

  }

  
}
