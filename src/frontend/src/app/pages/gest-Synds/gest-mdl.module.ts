import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {SharedModule} from "../../common/shared/shared.module";
import { SyndsComponent} from './components/synd-list/synds-list.component';
import {CandidatComponent} from './components/candida-list/candidats-list.component';
import { MdlViewComponent } from './components/mdl-view/mdl-view.component';
import { GestSynd1RoutingModule} from "./gest-mdl-routing.module";
import {SyndicatService} from "../gest-prof/services/syndicat.service";
import {Syndicat1Service} from "./services/synd.service";


@NgModule({
  declarations: [
    SyndsComponent,
    CandidatComponent,
    MdlViewComponent
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
