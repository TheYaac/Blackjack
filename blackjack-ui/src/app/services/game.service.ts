import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http:HttpClient) {
    
    startGame() {
      return this.http.get("/server/api/v1/game")
    }

   }
}
