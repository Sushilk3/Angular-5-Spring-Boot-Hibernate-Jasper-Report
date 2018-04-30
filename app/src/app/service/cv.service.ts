/**
 * Created by SRX on 1/8/2018.
 */

import {Injectable} from '@angular/core';
import {Configuration} from './app.constans';
import {Http, Headers, Response} from '@angular/http';
import {CurriculumVitaeModel} from "../model/cv.model";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';

@Injectable()
export class CurriculumViteaService {

  constructor (private http: Http){}

  // POST cv.register.component.ts
  sendCV(request: CurriculumVitaeModel){
    let header = new Headers({'Content-Type': 'application/json'});
    return this.http.post(Configuration.Url +"cv/send", JSON.stringify(request), {headers: header});
  }


  // GET cv.report.component.ts
  getCV(): Observable<Object[]> {
    return this.http.get(Configuration.Url+"cv/list").map((res:Response) => <Object[]>res.json());
  }
  getCVs(): Observable<Object[]> {
    return this.http.get(Configuration.Url+"cv/lists").map((res:Response) => <Object[]>res.json());
  }
}
