import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import { MaterialModule } from './material/MaterialModule';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import  { HttpClientModule, provideHttpClient } from '@angular/common/http';
import { LoginAttemptsListComponent } from './modules/admin/components/login-attempts-list/login-attempts-list.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LoginAttemptsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    provideAnimationsAsync(),
    provideHttpClient()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
