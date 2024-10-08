import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { UsersListComponent } from './components/users-list/users-list.component';
import { MaterialModule } from '../../material/MaterialModule';
import { SignupUserComponent } from './components/signup-user/signup-user.component';


@NgModule({
  declarations: [
    DashboardComponent,
    UsersListComponent,
    SignupUserComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MaterialModule
  ]
})
export class AdminModule { }
