import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {

  headers = new HttpHeaders({ 'Access-Control-Allow-Origin': '*' })

  constructor(private http: HttpClient) { }
  getAllGenres():any{
    return this.http.get("http://13.235.52.81:8083/recommendation-service/genres");
    // return this.http.get("http://localhost:8083/recommendation-service/genres");
  }

}
