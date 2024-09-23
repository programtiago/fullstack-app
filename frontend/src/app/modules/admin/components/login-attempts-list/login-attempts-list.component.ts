import { Component } from '@angular/core';
import { Observable, pipe } from 'rxjs';
import { LoginAttempt } from '../../../../interface/login-attempt';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-login-attempts-list',
  templateUrl: './login-attempts-list.component.html',
  styleUrl: './login-attempts-list.component.scss'
})
export class LoginAttemptsListComponent {


  displayedColumns: string[] = ['email', 'loginAttemptDateTime', 'ipAddressSource', "userAgent", 'actions']

  loginAttempts$: Observable<LoginAttempt[]>;
  loginAttempts: LoginAttempt[] = [];

  constructor(private adminService: AdminService){
    this.loginAttempts$ = this.adminService.getLoginAttempts();
    this.adminService.getLoginAttempts().subscribe(login => login.filter(loginAtte => console.log(loginAtte.userAgent)))
  }
}
