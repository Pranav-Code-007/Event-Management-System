import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Model/User';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private _httpClient:HttpClient) { }
   BASE_URL:string="http://localhost:8089/user/";

  getUserById(userId:number):Observable<User>{
    return this._httpClient.get<User>(this.BASE_URL+"getUser/"+userId);
  }

  addUser(user:User):Observable<string>{
    return this._httpClient.post<string>(this.BASE_URL+"addUser",user);
  }

  updateUser(userId:number, user:User):Observable<string>{
    return this._httpClient.put<string>(this.BASE_URL+"updateUser/"+userId,user);
  }
// http://localhost:8089/user/get_all_users_by_role/user
  getAllUserByRole(role:string):Observable<User[]>{
    return this._httpClient.get<User[]>(this.BASE_URL+"get_all_users_by_role/"+role);
  }

  deleteUserById(userId:number):Observable<boolean>{
     return this._httpClient.delete<boolean>(this.BASE_URL+"deleteUser/"+userId);
  }

  loginUser(user:User):Observable<string>{
    return this._httpClient.post<string>(this.BASE_URL+"login",user);
  }

  verifyOtp(user_email:string | any,otp:string){
    return this._httpClient.post<string>(this.BASE_URL+"otp/"+user_email+"/"+otp,null);
  }

  getUserByEmail(user_email:string | any):Observable<User>{
    return this._httpClient.get<User>(this.BASE_URL+"getUserByEmail/"+user_email);
  }

  
  
}
