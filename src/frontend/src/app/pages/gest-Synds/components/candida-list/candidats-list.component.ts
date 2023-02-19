import {Component, Input, OnInit} from '@angular/core';
import { Syndicat1Service} from "../../services/synd.service";
import {MatDialog} from "@angular/material/dialog";
import {DialogConfirmComponent} from "../../../../common-elements/dialog-confirm/dialog-confirm.component";
import {Icandidat} from "../../models/iCandidat";
import {IEtudiant} from "../../../../models/etudiant";
import {EtudService} from "../../../../services/etudiants.service";

@Component({
  selector: 'app-matiere-list',
  templateUrl: './candidats-list.component.html',
})
export class CandidatComponent implements OnInit {

  @Input("idSynd") idSynd: any;
  candidats: Icandidat[] = [];
  etudiants: IEtudiant[] = [];
  curCandidat = <Icandidat>{};

  constructor(private syndicat1Service: Syndicat1Service,
              private etudiantService: EtudService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getCandidats();

    this.getEtudiants();
  }


  private getEtudiants() {
    this.etudiantService.getNoms().subscribe(data => {
      this.etudiants = data;
    })
  }

  private getCandidats() {
    this.syndicat1Service.getCandidats(this.idSynd).subscribe(data => {
      this.candidats = data;
    })
  }

  fillForm(mat: Icandidat) {
    this.curCandidat = mat;
  }

  delete(id: number) {
    let dialogRef = this.dialog.open(DialogConfirmComponent, {
      width: '250px'
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.syndicat1Service.delete(id).subscribe(data => {
          this.getCandidats();
        })
      }
    });


  }

  save() {
    if (this.curCandidat.id) {
      console.log("this.curCandidat.id: ", this.curCandidat.id)
      this.syndicat1Service.update(this.curCandidat).subscribe(() => {
        this.curCandidat = <Icandidat>{}
        console.log("this.curCandidat ==== ", this.curCandidat)
        this.getCandidats();
      })
    } else {
      this.curCandidat.idSyndicat = this.idSynd;
      this.syndicat1Service.add(this.curCandidat).subscribe(() => {
        this.curCandidat = <Icandidat>{}
        this.getCandidats();
      })
    }
  }
}
