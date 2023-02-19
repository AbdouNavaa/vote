import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {SharedModule} from "../../common/shared/shared.module";
import { SyndsComponent} from './components/synd-list/synds-list.component';
import {CandidatComponent} from './components/candida-list/candidats-list.component';
import { GestSynd1RoutingModule} from "./gest-synds-routing.module";
import {Syndicat1Service} from "./services/synd.service";


@NgModule({
  declarations: [
    SyndsComponent,
    CandidatComponent,
  ],
  imports: [
    CommonModule,
    GestSynd1RoutingModule,
    SharedModule
  ],
  providers: [
    Syndicat1Service,
  ]
})
export class GestSynd1Module { }
