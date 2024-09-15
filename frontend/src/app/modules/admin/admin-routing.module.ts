import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { UsersListComponent } from './components/users-list/users-list.component';
import { SignupUserComponent } from './components/signup-user/signup-user.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent},
  { path: 'users-list', component: UsersListComponent},
  { path: 'new-user', component: SignupUserComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
