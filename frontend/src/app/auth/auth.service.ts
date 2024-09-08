import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

const BASE_URL = "api/v1"

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(loginRequest: any): Observable<any>{
    return this.http.post(BASE_URL + "/auth/login", loginRequest);
  }
}
