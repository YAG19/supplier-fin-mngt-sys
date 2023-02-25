import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FileUploadService } from './FileUploadService.service';

const baseUrl = 'http://localhost:8081/api/invoice';
@Injectable({
  providedIn: 'root'
})
export class InvoiceUploadService {

  public login(value: any, value1: any): Observable<any> {
    const userDto = {
      username: value,
      password: value1
    }
    const url = '/login'
    return this.http.post(baseUrl + url, userDto);
  }

  constructor(private http: HttpClient,
    private fileuploadService: FileUploadService
    ) { }

  invoiceUpload(data: any,file: File): Observable<any> {
    return this.fileuploadService.upload(data,file);
  }

}
