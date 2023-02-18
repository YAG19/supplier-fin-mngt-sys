import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080/api/client/registration';

@Injectable({providedIn: 'root'})
export class ClientService {

  constructor(private http: HttpClient) { }

  create(data: any): Observable<any> {
    console.log("--inside ClientService ");

    return this.http.post(baseUrl, data);
  }

}
