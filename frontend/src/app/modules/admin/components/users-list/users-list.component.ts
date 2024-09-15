import { Component } from '@angular/core';
import { User } from '../../../../interface/user';
import { Observable } from 'rxjs';
import { AdminService } from '../../services/admin.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrl: './users-list.component.scss'
})
export class UsersListComponent {

  users: User[] = [];
  users$: Observable<User[]>;

  displayedColumns: string[] = ['firstName', 'lastName', 'email', 'role', 'createdAt', 'actions']

  constructor(private adminService: AdminService, 
              private router: Router,
              private snackBar: MatSnackBar,
              private dialog: MatDialog
  ){
    this.users$ = this.adminService.getUsers();
  }

}
