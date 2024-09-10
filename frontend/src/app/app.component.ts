import { Component, OnInit } from '@angular/core';
import { StorageService } from './auth/storage/storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit{
  userId!: string;
  loggedUserId!: string;

  isEmployeeLoggedIn:boolean = StorageService.isEmployeeLoggedIn();
  isAdminLoggedIn:boolean = StorageService.isAdminLoggedIn();
 
  constructor(private router: Router){}

  ngOnInit(): void {
    this.router.events.subscribe(event=>{
      this.isEmployeeLoggedIn = StorageService.isEmployeeLoggedIn();
      this.isAdminLoggedIn = StorageService.isAdminLoggedIn();
    })
  }

  openSideNav(){}

  logout(){
    StorageService.logout();
    this.router.navigateByUrl("login");
  }

}
