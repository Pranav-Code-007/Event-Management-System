import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule } from '@angular/common/http'


import { EventSearchPipe } from './Utilities/Helper/event-search.pipe';
import { UserProfileComponent } from './Components/User/user-profile/user-profile.component';
import { UserBookedEventsComponent } from './Components/User/user-booked-events/user-booked-events.component';
import { UserShowEventsComponent } from './Components/User/user-show-events/user-show-events.component';

import {MatFormFieldModule} from '@angular/material/form-field'; 
import {MatButtonModule} from '@angular/material/button'; 
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {  MatInputModule } from '@angular/material/input';
import { UserListComponent } from './Components/Admin/User/user-list/user-list.component';
import { UserSearchPipe } from './Utilities/Helper/user-search.pipe';
import { UpdateUserComponent } from './Components/Admin/User/update-user/update-user.component';
import { LoginComponent } from './Components/General/login/login.component';
import { SignupComponent } from './Components/General/signup/signup.component';
import { OtpComponent } from './Components/General/otp/otp.component';
import { AllEventComponent } from './Components/EventOrganizer/all-event/all-event.component';
import { AdminDashboardComponent } from './Components/Admin/admin-dashboard/admin-dashboard.component';
import { PageNorFoundComponent } from './Components/General/page-nor-found/page-nor-found.component';
import { HomeComponent } from './Components/General/home/home.component';
import { LogoutComponent } from './Components/General/logout/logout.component';
import { EventCategoryComponent } from './Components/Admin/EventCategory/event-category/event-category.component';
import { EventCategoryUpdateComponent } from './Components/Admin/EventCategory/event-category-update/event-category-update.component';
import { FeedbackComponent } from './Components/User/feedback/feedback.component';
import { FeedbackListComponent } from './Components/Admin/Feedback/feedback-list/feedback-list.component';
import { AddEventComponent } from './Components/EventOrganizer/add-event/add-event.component';
import { EditEventComponent } from './Components/EventOrganizer/edit-event/edit-event.component';
import { OrganizerListComponent } from './Components/Admin/Organizer/organizer-list/organizer-list.component';
import { UpdateOrganizerComponent } from './Components/Admin/Organizer/update-organizer/update-organizer.component';
import { AllBookingComponent } from './Components/Admin/Booking/all-booking/all-booking.component';


@NgModule({
  declarations: [
    AppComponent,
    EventSearchPipe,
    UserProfileComponent,
    UserBookedEventsComponent,
    UserShowEventsComponent,
    UserListComponent,
    UserSearchPipe,
    UpdateUserComponent,
    LoginComponent,
    SignupComponent,
    OtpComponent,
    AllEventComponent,
    AdminDashboardComponent,
    PageNorFoundComponent,
    HomeComponent,
    LogoutComponent,
    EventCategoryComponent,
    EventCategoryUpdateComponent,
    FeedbackComponent,
    FeedbackListComponent,
    AddEventComponent,
    EditEventComponent,
    OrganizerListComponent,
    UpdateOrganizerComponent,
    AllBookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatNativeDateModule,
    MatInputModule,
    MatDatepickerModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule 
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
