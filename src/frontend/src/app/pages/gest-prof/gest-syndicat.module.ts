import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {SharedModule} from "../../common/shared/shared.module";
import {EtudiantService} from "./services/etudiant.service";
import {GestSyndicatRoutingModule} from "./gest-syndicat-routing.module";
import {SyndicatListComponent} from "./components/syndicats-list/syndicat-list.component";
import {SyndicatService} from "./services/syndicat.service";


@NgModule({
  declarations: [
    SyndicatListComponent,
  ],
  imports: [
    CommonModule,
    GestSyndicatRoutingModule,
    SharedModule
  ],
  providers: [
    SyndicatService
  ]
})
export class GestSyndicatModule { }
