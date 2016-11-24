import { Injectable } from '@angular/core';
import {Http, Headers} from "@angular/http";
import 'rxjs/add/operator/map'

@Injectable()
export class BalanceService {

  constructor(private http: Http) {

  }

  load() {
    return this.http.get('http://localhost:8080/api/balance')
      .map(response => response.json())
  }

  submit(deposit:number) {
    console.log(deposit);
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/api/deposit', {"depositAmount":deposit}, headers);
  }

}
