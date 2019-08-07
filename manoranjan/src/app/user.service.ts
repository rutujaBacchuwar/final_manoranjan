import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { User } from './user';
import {Producer} from './producer';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userService: any;
  route: any;
  headers = new HttpHeaders({'Access-Control-Allow-Origin' : '*'})
  constructor(private http:HttpClient) { }

  saveUser(user:User){
  //  return this.http.post<User>("http://13.235.52.81:8083/user-service/user",user);
   return this.http.post<User>("http://localhost:8083/user-service/user",user);
  }
  getById(emailId):any{
    // return this.http.get("http://13.235.52.81:8083/user-service/users/"+emailId,{
      return this.http.get("http://localhost:8083/user-service/users/"+emailId,{
      headers:new HttpHeaders({
        'Access-Control-Allow-Origin' : '*'
      })
    });
   }
  getAllUsers():any{
    // return this.http.get("http://13.235.52.81:8083/user-service/users");
    return this.http.get("http://localhost:8083/user-service/users");
  }
  updateUser(emailId,user:User):any{
    // return this.http.put("http://13.235.52.81:8083/user-service/user/"+emailId,user,{
      return this.http.put("http://localhost:8083/user-service/user/"+emailId,user,{
      headers:new HttpHeaders({
        'Access-Control-Allow-Origin' : '*'
      })
    });
  }

  addToStandaloneWishlist(emailId,title){
    // return this.http.put("http://13.235.52.81:8083/user-service/user/wish/standalone/"+emailId+"/"+title,{});
    return this.http.put("http://localhost:8083/user-service/user/wish/standalone/"+emailId+"/"+title,{});
  }

  addToEpisodicWishlist(emailId,title){
    // return this.http.put("http://13.235.52.81:8083/user-service/user/wish/episodic/"+emailId+"/"+title,{});
    return this.http.put("http://localhost:8083/user-service/user/wish/episodic/"+emailId+"/"+title,{});
  }

  getStandaloneWishlist(emailId){
    // return this.http.get("http://13.235.52.81:8083/user-service/user/wish/standalone/"+emailId,{});
    return this.http.get("http://localhost:8083/user-service/user/wish/standalone/"+emailId,{});
  }

  getEpisodicWishlist(emailId){
    // return this.http.get("http://13.235.52.81:8083/user-service/user/wish/episodic/"+emailId,{});
    return this.http.get("http://localhost:8083/user-service/user/wish/episodic/"+emailId,{});
  }

  addToStandaloneHistory(emailId,title){
    // return this.http.put("http://13.235.52.81:8083/user-service/user/history/standalone/"+emailId+"/"+title,{});
    return this.http.put("http://localhost:8083/user-service/user/history/standalone/"+emailId+"/"+title,{});
  }

  addToEpisodicHistory(emailId,title){
    // return this.http.put("http://13.235.52.81:8083/user-service/user/history/episodic/"+emailId+"/"+title,{});
    return this.http.put("http://localhost:8083/user-service/user/history/episodic/"+emailId+"/"+title,{});
  }

  getStandaloneHistory(emailId){
    // return this.http.get("http://13.235.52.81:8083/user-service/user/history/standalone/"+emailId,{});
    return this.http.get("http://localhost:8083/user-service/user/history/standalone/"+emailId,{});
  }

  getEpisodicHistory(emailId){
    // return this.http.get("http://13.235.52.81:8083/user-service/user/history/episodic/"+emailId,{});
    return this.http.get("http://localhost:8083/user-service/user/history/episodic/"+emailId,{});
  }
  updateProducer(emailId,producer:Producer):any{
    // return this.http.put("http://13.235.52.81:8083/user-service/user/"+emailId,producer,{
      return this.http.put("http://localhost:8083/user-service/producer/"+emailId,producer,{
      headers:new HttpHeaders({
        'Access-Control-Allow-Origin' : '*'
      })
    });
  }
  getByEmailId(emailId):any{
    // return this.http.get("http://13.235.52.81:8083/user-service/users/"+emailId,{
      return this.http.get("http://localhost:8083/user-service/producers/"+emailId,{
      headers:new HttpHeaders({
        'Access-Control-Allow-Origin' : '*'
      })
    });
   }
  getUploadedStandaloneTitle(emailId):any{
    //  return this.http.get("http://13.235.52.81:8083/user-service/producer/standalone/"+emailId,{});
        return this.http.get("http://localhost:8083/user-service/producer/standalone/"+emailId,{
          headers:new HttpHeaders({
            'Access-Control-Allow-Origin' : '*'
          })
        });
  }
  getUploadedEpisodicTitle(emailId):any{
    //    return this.http.get("http://13.235.52.81:8083/user-service/producer/episodic/"+emailId,{});
          return this.http.get("http://localhost:8083/user-service/producer/episodic/"+emailId,{
            headers:new HttpHeaders({
              'Access-Control-Allow-Origin' : '*'
            })
          });
  }

  updateUploadedStandalone(emailId,title){
    //    return this.http.get("http://13.235.52.81:8083/user-service/producer/standalone/"+emailId+"/"+title,{});
    return this.http.put("http://localhost:8083/user-service/producer/standalone/"+emailId+"/"+title,{ 
      headers:new HttpHeaders({
      'Access-Control-Allow-Origin' : '*'
    })});
  }

  updateUploadedEpisodic(emailId,title){
    //    return this.http.get("http://13.235.52.81:8083/user-service/producer/episodic/"+emailId+"/"+title,{});
    return this.http.put("http://localhost:8083/user-service/producer/episodic/"+emailId+"/"+title,{
      headers:new HttpHeaders({
        'Access-Control-Allow-Origin' : '*'
      })
    });
  }

}
