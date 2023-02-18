import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {IEtudiant} from "../models/etudiant";

@Injectable()
export class EtudiantService {

  constructor(private http: HttpClient) {
  }

  getEtudaints() {
    return this.http.get<IEtudiant[]>("http://localhost:8080/etudiant")
  }


  update(curEtud: IEtudiant) {
    return this.http.put("http://localhost:8080/etudiant/" + curEtud.id, curEtud);
  }

  add(curEtud: IEtudiant) {
    return this.http.post("http://localhost:8080/etudiant", curEtud);
  }

  delete(id: number) {
    return this.http.delete("http://localhost:8080/etudiant/" + id);
  }
}

