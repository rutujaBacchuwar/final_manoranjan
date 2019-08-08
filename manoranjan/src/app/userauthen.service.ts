import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Userauthen } from './userauthen';
@Injectable({
  providedIn: 'root'
})
export class UserauthenService {
  route: any;
  headers = new HttpHeaders({'Access-Control-Allow-Origin' : '*'})
  constructor(private http:HttpClient) { }
  login(user:Userauthen){
     return this.http.post<Userauthen>("http://13.235.52.81:8083/user-authentication-service/user",user);
   // return this.http.post<Userauthen>("http://localhost:8083/user-authentication-service/user",user);
   }
}
