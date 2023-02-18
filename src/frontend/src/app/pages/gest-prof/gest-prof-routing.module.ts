import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProfListComponent} from "./components/profs-list/prof-list.component";

const routes: Routes = [
  {
    path: "",
    component: ProfListComponent
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GestProfRoutingModule { }
