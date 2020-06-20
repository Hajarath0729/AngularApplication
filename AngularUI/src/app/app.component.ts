import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AssignmentService } from '../../src/services/assignment.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'AngularUI';
  phoneNumberForm: FormGroup;
  alphaNumericPhoneNumbersList: any = [];
  pager: any = {};
  pageSize: number = 10;
  pagedItems: any[];
  pageOfItems: Array<any>;

  constructor(private formBuilder: FormBuilder, private assignmentService: AssignmentService) { }

  ngOnInit() {

    this.phoneNumberForm = this.formBuilder.group({
        phoneNumber: ['', Validators.compose([Validators.required, Validators.pattern("^([0-9]{7})$|(^[0-9]{10})$")])],
    });
  }

  alphaNumericPhoneNumbers() {
    this.assignmentService.getAlphaNumericPhoneNumbers(this.phoneNumberForm.controls['phoneNumber'].value).subscribe(data => {
      this.alphaNumericPhoneNumbersList = data;
      this.alphaNumericPhoneNumbersList.size
    })
  }

  onChangePage(pageOfItems: Array<any>) {
    this.pageOfItems = pageOfItems;
}

}
