import { Component } from '@angular/core';
import { StorageService } from './auth/storage/storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  userId!: string;
  loggedUserId!: string;

  isEmployeeLoggedIn:boolean = StorageService.isEmployeeLoggedIn();
  isAdminLoggedIn:boolean = StorageService.isAdminLoggedIn();
}
