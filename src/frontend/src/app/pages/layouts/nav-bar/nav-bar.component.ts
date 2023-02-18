import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../authentification.service";
import {UtilService} from "../../../services/util.service";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private authentificationService: AuthentificationService,public util: UtilService) { }

  ngOnInit(): void {
  }

  logOut() {
    this.authentificationService.logOut();
  }

}
