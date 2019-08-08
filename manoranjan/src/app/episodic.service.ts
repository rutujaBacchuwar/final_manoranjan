import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Episodic } from './episodic';

@Injectable({
  providedIn: 'root'
})
export class EpisodicService {

  constructor(private http: HttpClient) { }

  getShowsByLanguage(language:string){
    // return this.http.get('http://13.235.52.81:8083/episodic-media-service/episodic-media/tv/'+language,{
      return this.http.get('http://localhost:8083/episodic-media-service/episodic-media/tv/'+language,{
        headers:new HttpHeaders({
        'Access-Control-Allow-Origin' : '*'
      })
    });
  }

  getEpisodic(episodicMedia:string){
    // return this.http.get('http://13.235.52.81:8083/episodic-media-service/episodic-media/category/'+episodicMedia,{
      return this.http.get('http://localhost:8083/episodic-media-service/episodic-media/category/'+episodicMedia,{
        headers:new HttpHeaders({
        'Access-Control-Allow-Origin' : '*'
      })
    });
  }

  saveEpisodicMedia(episodicMedia:Episodic){
    // return this.http.post<Episodic>("http://13.235.52.81:8083/episodic-media-service/episodic-media",episodicMedia);
    return this.http.post<Episodic>("http://localhost:8083/episodic-media-service/episodic-media",episodicMedia);
  }

  getWishlist(titles:Array<string>){
    // return this.http.patch('http://13.235.52.81:8083/episodic-media-service/wish',titles);
    return this.http.patch('http://localhost:8083/episodic-media-service/wish',titles);
  }
}
