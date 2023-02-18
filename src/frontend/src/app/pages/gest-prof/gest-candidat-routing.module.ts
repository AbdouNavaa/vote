import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CandidatListComponent} from "./components/candidat-list/candidat-list.component";

const routes: Routes = [
  {
    path: "",
    component: CandidatListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GestCandidatRoutingModule { }
