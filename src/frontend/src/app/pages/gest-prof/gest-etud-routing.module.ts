import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EtudListComponent} from "./components/etudiant-list/etud-list.component";

const routes: Routes = [
  {
    path: "",
    component: EtudListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GestEtudRoutingModule { }
