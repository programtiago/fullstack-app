import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../../auth/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { StorageService } from '../../auth/storage/storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  loginForm!: FormGroup;
  hidePassword = true;


  public constructor(private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private router: Router,
    private authService: AuthService
  ){
    this.loginForm = this.fb.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]]
    })

  }

  tooglePasswordVisibility(){
    this.hidePassword = !this.hidePassword;
  }

  onSubmit(){
    console.log(this.loginForm.value)
    this.authService.login(this.loginForm.value).subscribe((res) => {
      if(res.userId != null){
        const user = {
          userId:res.userId,
          userRole:res.userRole
        }
        StorageService.saveUser(user);
        StorageService.saveToken(res.token)
        
        if (StorageService.isAdminLoggedIn()){
          this.snackBar.open("Login sucessfull " + user.userRole, "Close", { duration: 5000 });
          this.router.navigateByUrl("admin/dashboard");
          console.log("Admin logado")
        }else if (StorageService.isEmployeeLoggedIn()){
          this.snackBar.open("Login sucessfull " + user.userRole, "Close", { duration: 5000 });
          this.router.navigateByUrl("employee/dashboard");
          console.log("Employee logado")
      }
    }else{
      console.log("erro")
      this.snackBar.open("Invalid credentials", "Close", { duration: 5000, panelClass: "error-snackbar"})
    }
  })}

}
