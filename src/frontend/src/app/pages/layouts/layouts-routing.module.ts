import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {AppGuard} from "../../services/app.guard";

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    canActivate: [AppGuard],
    children: [
      {
        path: 'apropos',
        loadChildren: () =>
          import('../apropos/apropos.module').then(
            (m) => m.AproposModule
          ),
      },
      {
        path: 'admin',
        loadChildren: () =>
          import('../admin/admin.module').then(
            (m) => m.AdminModule
          ),
      },
      {
        path: 'gestMdl',
        loadChildren: () =>
          import('../gest-Synds/gest-mdl.module').then(
            (m) => m.GestSynd1Module
          ),
      },
      {
        path: 'gestEtud',
        loadChildren: () =>
          import('../gest-prof/gest-etud.module').then(
            (m) => m.GestEtudModule
          ),
      },
      {
        path: 'gestSyndicats',
        loadChildren: () =>
          import('../gest-prof/gest-syndicat.module').then(
            (m) => m.GestSyndicatModule
          ),
      },

    ]
  },
  {
    path: 'login',
    component: LoginComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutsRoutingModule { }
