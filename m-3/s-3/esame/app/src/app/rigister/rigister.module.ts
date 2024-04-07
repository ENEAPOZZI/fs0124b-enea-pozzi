import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RigisterRoutingModule } from './rigister-routing.module';
import { RigisterComponent } from './rigister.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    RigisterComponent
  ],
  imports: [
    CommonModule,
    RigisterRoutingModule,
    FormsModule
  ]
})
export class RigisterModule { }
