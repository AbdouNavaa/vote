import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from "@angular/material/card";
import {MatError, MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatChipsModule} from "@angular/material/chips";
import {MatIconModule} from "@angular/material/icon";
import {MatDialog, MatDialogModule} from "@angular/material/dialog";



@NgModule({
  exports: [
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatChipsModule,
    MatIconModule,
    MatDialogModule
  ],
  providers: [
    MatDialog
  ]
})
export class MaterialModule { }
