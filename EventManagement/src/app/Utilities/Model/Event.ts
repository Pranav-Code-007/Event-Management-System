import { Booking } from "./Booking";
import { User } from "./User";

export class Event{
    eventId:any=null;
	name:string="";
	category:string="";	
	venue:string="";
	date:Date=new Date();
    time:any=null;   
    price:Number=0;

    description:string=""
    
	user:User = new User();
}