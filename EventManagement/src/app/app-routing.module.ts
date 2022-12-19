import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './Components/Admin/admin-dashboard/admin-dashboard.component';
import { AllBookingComponent } from './Components/Admin/Booking/all-booking/all-booking.component';
import { EventCategoryUpdateComponent } from './Components/Admin/EventCategory/event-category-update/event-category-update.component';
import { EventCategoryComponent } from './Components/Admin/EventCategory/event-category/event-category.component';
import { FeedbackListComponent } from './Components/Admin/Feedback/feedback-list/feedback-list.component';
import { OrganizerListComponent } from './Components/Admin/Organizer/organizer-list/organizer-list.component';
import { UpdateOrganizerComponent } from './Components/Admin/Organizer/update-organizer/update-organizer.component';
import { UpdateUserComponent } from './Components/Admin/User/update-user/update-user.component';
import { UserListComponent } from './Components/Admin/User/user-list/user-list.component';
import { AddEventComponent } from './Components/EventOrganizer/add-event/add-event.component';
import { AllEventComponent } from './Components/EventOrganizer/all-event/all-event.component';
import { EditEventComponent } from './Components/EventOrganizer/edit-event/edit-event.component';
import { HomeComponent } from './Components/General/home/home.component';
import { LoginComponent } from './Components/General/login/login.component';
import { LogoutComponent } from './Components/General/logout/logout.component';
import { OtpComponent } from './Components/General/otp/otp.component';
import { PageNorFoundComponent } from './Components/General/page-nor-found/page-nor-found.component';
import { SignupComponent } from './Components/General/signup/signup.component';
import { FeedbackComponent } from './Components/User/feedback/feedback.component';
import { UserBookedEventsComponent } from './Components/User/user-booked-events/user-booked-events.component';
import { UserProfileComponent } from './Components/User/user-profile/user-profile.component';
import { UserShowEventsComponent } from './Components/User/user-show-events/user-show-events.component';

const routes: Routes = [
  
  {path:"signup",component:SignupComponent},
  {path:"login",component:LoginComponent},
  {path:"logout",component:LogoutComponent},
  {path:"otp",component:OtpComponent},
  {path:"user_account_show_events",component:UserShowEventsComponent},
  {path:"user_account_booked_events",component:UserBookedEventsComponent},
  {path:"user_account_profile",component:UserProfileComponent},
  {path:"feedback",component:FeedbackComponent},

  {path:"organizer_account_show_events",component:AllEventComponent},
  {path:"addEvent",component:AddEventComponent},
  {path:"editEvent/:id",component:EditEventComponent},

  {path:"event_category",component:EventCategoryComponent},
  {path:"edit_event_category/:category",component:EventCategoryUpdateComponent},
  {path:"get_all_booking",component:AllBookingComponent},
  {path:"admin_dashboard",component:AdminDashboardComponent},
  {path:"admin_user_list",component:UserListComponent},
  {path:"admin_user_update/:id",component:UpdateUserComponent},
  {path:"feedbacklist",component:FeedbackListComponent},
  {path:"admin_organizer_list",component:OrganizerListComponent},
  {path:"admin_organizer_update/:id",component:UpdateOrganizerComponent},

  {path:"home",component:HomeComponent},
  {path:"page_not_found",component:PageNorFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
