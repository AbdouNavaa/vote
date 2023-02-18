import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GestProfRoutingModule } from './gest-prof-routing.module';
import {SharedModule} from "../../common/shared/shared.module";
import {ProfListComponent} from "./components/profs-list/prof-list.component";
import {ProfService} from "./services/prof.service";


@NgModule({
  declarations: [
    ProfListComponent,
  ],
  imports: [
    CommonModule,
    GestProfRoutingModule,
    SharedModule
  ],
  providers: [
    ProfService
  ]
})
export class GestProfModule { }
