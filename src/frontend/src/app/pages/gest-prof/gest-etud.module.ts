import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {SharedModule} from "../../common/shared/shared.module";
import {EtudListComponent} from "./components/etudiant-list/etud-list.component";
import {GestEtudRoutingModule} from "./gest-etud-routing.module";
import {EtudiantService} from "./services/etudiant.service";


@NgModule({
  declarations: [
    EtudListComponent,
  ],
  imports: [
    CommonModule,
    GestEtudRoutingModule,
    SharedModule
  ],
  providers: [
    EtudiantService
  ]
})
export class GestEtudModule { }
