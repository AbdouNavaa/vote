import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ICandidat} from "../models/candidat";


@Injectable()
export class CandidatService {

  constructor(private http: HttpClient) {
  }

  getCandidats() {
    return this.http.get<ICandidat[]>("http://localhost:8080/candidat")
  }


  update(curCand: ICandidat) {
    return this.http.put("http://localhost:8080/candidat/" + curCand.id, curCand);
  }

  add(curCand: ICandidat) {
    return this.http.post("http://localhost:8080/candidat", curCand);
  }

  delete(id: number) {
    return this.http.delete("http://localhost:8080/candidat/" + id);
  }
}

