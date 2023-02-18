import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {IRef} from "../models/iref";

@Injectable()
export class ProfService {

  constructor(private http: HttpClient) {
  }

  getProfesseurs() {
    return this.http.get<IRef[]>("http://localhost:8080/referentiel/professeurs")
  }


  updateProf(curProf: IRef) {
    return this.http.put("http://localhost:8080/referentiel/" + curProf.id, curProf);
  }

  addProf(curProf: IRef) {
    return this.http.post("http://localhost:8080/referentiel", curProf);
  }

  delete(id: number) {
    return this.http.delete("http://localhost:8080/referentiel/" + id);
  }
}
