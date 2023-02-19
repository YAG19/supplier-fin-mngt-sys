import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080/api/client';

@Injectable({providedIn: 'root'})
export class ClientService {

  public login(value: any, value1: any): Observable<any> {
    const userDto = {
      username: value,
      password: value1
    }
    const url = '/login'
    return this.http.post(baseUrl + url, userDto);
  }

  constructor(private http: HttpClient) { }

  create(data: any): Observable<any> {
    console.log("--inside ClientService ");
    const url = '/registration';
    return this.http.post(baseUrl + url, data);
  }

}
