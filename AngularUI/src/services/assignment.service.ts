import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AssignmentService {

  constructor(private httpClient: HttpClient) { }

  getAlphaNumericPhoneNumbers(phoneNumber) {
    return this.httpClient.get("http://localhost:8080/alpha-numeric-phonenumbers?phoneNumber=" + phoneNumber);
  }
}
