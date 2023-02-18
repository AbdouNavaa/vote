import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {DialogConfirmComponent} from "../../../../common-elements/dialog-confirm/dialog-confirm.component";
import {ISyndicat} from "../../models/syndicat";
import {SyndicatService} from "../../services/syndicat.service";

@Component({
  selector: 'app-matiere-list',
  templateUrl: './syndicat-list.component.html',
  // styleUrls: ['./matiere-list.component.css']
})
export class SyndicatListComponent implements OnInit {

  syndicats: ISyndicat[] = [];
  cursyndicat = <ISyndicat>{}

  constructor(private syndicatService: SyndicatService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getSyndicats();

  }


  private getSyndicats() {
    this.syndicatService.getSyndicats().subscribe(data => {
      this.syndicats = data;
    })
  }


  fillForm(etudiant: ISyndicat) {
    this.cursyndicat = etudiant;
  }

  delete(id: number) {
    let dialogRef = this.dialog.open(DialogConfirmComponent, {
      width: '250px'
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.syndicatService.delete(id).subscribe(data => {
          this.getSyndicats();
        })
      }
    });


  }

  save() {
    if (this.cursyndicat.id) {
      console.log("this.cursyndicat.id: ", this.cursyndicat.id)
      this.syndicatService.update(this.cursyndicat).subscribe(() => {
        this.cursyndicat = <ISyndicat>{}
        console.log("this.cursyndicat ==== ", this.cursyndicat)
        this.getSyndicats();
      })
    } else {
      // this.cursyndicat.idMdl = this.idMdl;
      this.syndicatService.add(this.cursyndicat).subscribe(() => {
        this.cursyndicat = <ISyndicat>{}
        this.getSyndicats();
      })
    }
  }
}
