import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SyndicatListComponent} from "./components/syndicats-list/syndicat-list.component";

const routes: Routes = [
  {
    path: "",
    component: SyndicatListComponent
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GestSyndicatRoutingModule { }
