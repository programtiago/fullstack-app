import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatSnackBarModule,
    MatFormFieldModule,
    MatCardModule,
    MatIconModule
  ],
  exports: [
    MatToolbarModule,
    MatSnackBarModule,
    MatFormFieldModule,
    MatCardModule,
    MatIconModule
  ]
})
export class MaterialModule { }
