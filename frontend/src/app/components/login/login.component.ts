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
      console.log(res)
      if(res.userId != null){
        console.log("Resposta ID#: " + res.userId)
        const user = {
          id:res.userId,
          role:res.userRole
        }
        StorageService.saveUser(user);
        StorageService.saveToken(res.token)
        
        if (StorageService.isAdminLoggedIn()){
          this.snackBar.open("Login com sucesso " + user.role, "Close", { duration: 5000 });
        }else if (StorageService.isEmployeeLoggedIn()){
          this.snackBar.open("Login com sucesso " + user.role, "Close", { duration: 5000 });
      }
    }else{
      this.snackBar.open("Invalid credentials", "Close", { duration: 5000, panelClass: "error-snackbar"})
    }
  })}
}
