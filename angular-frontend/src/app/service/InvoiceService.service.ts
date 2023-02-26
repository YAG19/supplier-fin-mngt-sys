import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FileUploadService } from './FileUploadService.service';

const baseUrl = 'http://localhost:8080/api/invoice';
@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  constructor(private http: HttpClient,
    private fileuploadService: FileUploadService
    ) { }

  invoiceUpload(data: any,file: File): Observable<any> {
    return this.fileuploadService.upload(data,file);
  }

  getInvoiceDetails(username: string): Observable<any> {
    return this.http.get(baseUrl + `/details/${username}`);
  }

  getAllInvoiceDetials(): Observable<any> {
    return this.http.get(baseUrl + `/details`);
  }
}
