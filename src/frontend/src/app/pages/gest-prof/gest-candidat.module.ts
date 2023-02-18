import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {SharedModule} from "../../common/shared/shared.module";
import {GestCandidatRoutingModule} from "./gest-candidat-routing.module";
import {CandidatListComponent} from "./components/candidat-list/candidat-list.component";
import {CandidatService} from "./services/candidat.service";


@NgModule({
  declarations: [
    CandidatListComponent,
  ],
  imports: [
    CommonModule,
    GestCandidatRoutingModule,
    SharedModule
  ],
  providers: [
    CandidatService
  ]
})
export class GestCandidatModule { }
