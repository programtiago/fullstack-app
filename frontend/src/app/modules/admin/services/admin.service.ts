import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../../interface/user';
import { StorageService } from '../../../auth/storage/storage.service';
import { LoginAttempt } from '../../../interface/login-attempt';

const BASE_URL = "/api/v1/"

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]>{
    return this.http.get<User[]>(BASE_URL + "/users", {
      headers: this.createAuthorizationHeader()
    })
  }

  getLoginAttempts(): Observable<LoginAttempt[]>{
    return this.http.get<LoginAttempt[]>(BASE_URL + "/login-attempts", {
      headers: this.createAuthorizationHeader()
    })
  }

  private createAuthorizationHeader(): HttpHeaders{
    console.log("Token vindo do angular " + StorageService.getToken())
    return new HttpHeaders().set(
      'Authorization', 'Bearer ' + StorageService.getToken()
    )
  }

}
