import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {DialogConfirmComponent} from "../../../../common-elements/dialog-confirm/dialog-confirm.component";
import {ProfService} from "../../services/prof.service";
import {IRef} from "../../models/iref";

@Component({
  selector: 'app-matiere-list',
  templateUrl: './prof-list.component.html',
  // styleUrls: ['./matiere-list.component.css']
})
export class ProfListComponent implements OnInit {

  professeurs: IRef[] = [];
  curProf = <IRef>{}

  constructor(private profService: ProfService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getProfesseurs();

  }


  private getProfesseurs() {
    this.profService.getProfesseurs().subscribe(data => {
      this.professeurs = data;
    })
  }

  // private getMatieres() {
  //   this.mdlService.getMatieres(this.idMdl).subscribe(data => {
  //     this.matieres = data;
  //   })
  // }

  fillForm(prof: IRef) {
    this.curProf = prof;
  }

  delete(id: number) {
    let dialogRef = this.dialog.open(DialogConfirmComponent, {
      width: '250px'
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.profService.delete(id).subscribe(data => {
          this.getProfesseurs();
        })
      }
    });


  }

  save() {
    if (this.curProf.id) {
      console.log("this.curProf.id: ", this.curProf.id)
      this.profService.updateProf(this.curProf).subscribe(() => {
        this.curProf = <IRef>{}
        console.log("this.curProf ==== ", this.curProf)
        this.getProfesseurs();
      })
    } else {
      // this.curProf.idMdl = this.idMdl;
      this.profService.addProf(this.curProf).subscribe(() => {
        this.curProf = <IRef>{}
        this.getProfesseurs();
      })
    }
  }
}
