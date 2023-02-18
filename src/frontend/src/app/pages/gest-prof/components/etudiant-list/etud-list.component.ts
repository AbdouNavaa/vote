import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {DialogConfirmComponent} from "../../../../common-elements/dialog-confirm/dialog-confirm.component";
import {IEtudiant} from "../../models/etudiant";
import {EtudiantService} from "../../services/etudiant.service";

@Component({
  selector: 'app-matiere-list',
  templateUrl: './etud-list.component.html',
  // styleUrls: ['./matiere-list.component.css']
})
export class EtudListComponent implements OnInit {

  etudiants: IEtudiant[] = [];
  curetudiant = <IEtudiant>{}

  constructor(private etudiantService: EtudiantService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getEtudiants();

  }


  private getEtudiants() {
    this.etudiantService.getEtudaints().subscribe(data => {
      this.etudiants = data;
    })
  }


  fillForm(etudiant: IEtudiant) {
    this.curetudiant = etudiant;
  }

  delete(id: number) {
    let dialogRef = this.dialog.open(DialogConfirmComponent, {
      width: '250px'
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.etudiantService.delete(id).subscribe(data => {
          this.getEtudiants();
        })
      }
    });


  }

  save() {
    if (this.curetudiant.id) {
      console.log("this.curetudiant.id: ", this.curetudiant.id)
      this.etudiantService.update(this.curetudiant).subscribe(() => {
        this.curetudiant = <IEtudiant>{}
        console.log("this.curetudiant ==== ", this.curetudiant)
        this.getEtudiants();
      })
    } else {
      // this.curetudiant.idMdl = this.idMdl;
      this.etudiantService.add(this.curetudiant).subscribe(() => {
        this.curetudiant = <IEtudiant>{}
        this.getEtudiants();
      })
    }
  }
}
