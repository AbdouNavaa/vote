import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ISyndicat} from "../models/syndicat";

@Injectable()
export class SyndicatService {

  constructor(private http: HttpClient) {
  }

  getSyndicats() {
    return this.http.get<ISyndicat[]>("http://localhost:8080/gest-synd")
  }


  update(curSyndicat: ISyndicat) {
    return this.http.put("http://localhost:8080/gest-synd/" + curSyndicat.id, curSyndicat);
  }

  add(curSyndicat: ISyndicat) {
    return this.http.post("http://localhost:8080/gest-synd", curSyndicat);
  }

  delete(id: number) {
    return this.http.delete("http://localhost:8080/gest-synd/" + id);
  }
}

