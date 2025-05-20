import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TransferRequest } from '../models/TransferRequest.model';
import { Observable } from 'rxjs';
import { TransferResponse } from '../models/TransferResponse.model';

@Injectable({
  providedIn: 'root',
})
export class TransferService {
  private apiUrl = 'http://localhost:8080/transfers';

  constructor(private http: HttpClient) {}

  makeTransfer(transfer: TransferRequest): Observable<any> {
    return this.http.post(`${this.apiUrl}/make`, transfer);
  }

  getTransfers(): Observable<TransferResponse[]> {
    return this.http.get<TransferResponse[]>(`${this.apiUrl}/`);
  }
}
