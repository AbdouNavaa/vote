import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {DialogConfirmComponent} from "../../../../common-elements/dialog-confirm/dialog-confirm.component";
import {ICandidat} from "../../models/candidat";
import {CandidatService} from "../../services/candidat.service";
import {IEtudiant} from "../../models/etudiant";
import {ISyndicat} from "../../models/syndicat";
import {EtudiantService} from "../../services/etudiant.service";
import {SyndicatService} from "../../services/syndicat.service";

@Component({
  selector: 'app-matiere-list',
  templateUrl: './candidat-list.component.html',
  // styleUrls: ['./matiere-list.component.css']
})
export class CandidatListComponent implements OnInit {

  candidats: ICandidat[] = [];
  // etudiants: IEtudiant[] = [];
  // syndicats: ISyndicat[] = [];

  curcandidat = <ICandidat>{};

  constructor(
    private candidatService: CandidatService,
              // private etudiantService: EtudiantService,
              // private syndicatService: SyndicatService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getCandidates();

    // this.getEtudiant();
    // this.getSyndicat();
  }
  // private getEtudiant() {
  //   this.etudiantService.getEtudaints().subscribe(data => {
  //     this.etudiants = data;
  //   })
  // }
  // private getSyndicat() {
  //   this.syndicatService.getSyndicats().subscribe(data => {
  //     this.syndicats = data;
  //   })
  // }


  private getCandidates() {
    this.candidatService.getCandidats().subscribe(data => {
      this.candidats = data;
    })
  }


  fillForm(candidat: ICandidat) {
    this.curcandidat = candidat;
  }

  delete(id: number) {
    let dialogRef = this.dialog.open(DialogConfirmComponent, {
      width: '250px'
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.candidatService.delete(id).subscribe(data => {
          this.getCandidates();
        })
      }
    });


  }

  save() {
    if (this.curcandidat.id) {
      console.log("this.curcandidat.id: ", this.curcandidat.id)
      this.candidatService.update(this.curcandidat).subscribe(() => {
        this.curcandidat = <ICandidat>{}
        console.log("this.curcandidat ==== ", this.curcandidat)
        this.getCandidates();
      })
    } else {
      // this.curcandidat.idMdl = this.idMdl;
      this.candidatService.add(this.curcandidat).subscribe(() => {
        this.curcandidat = <ICandidat>{}
        this.getCandidates();
      })
    }
  }
}
