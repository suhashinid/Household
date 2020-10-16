import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ApiService} from '../../../core/service/api.service';

@Component({
  selector: 'app-create-item',
  templateUrl: './create-item.component.html',
  styleUrls: ['./create-item.component.scss']
})
export class CreateItemComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private router: Router, private apiService: ApiService) { }

  addForm: FormGroup;
  submitted = false;
  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      serialNumber: ['', Validators.required],
      brand: ['', Validators.required],
      model: ['', Validators.required],
      status: ['', Validators.required],
      dateBought: ['', Validators.required]
      
    });

  }

  onSubmit() {
    this.submitted=true;
    this.apiService.createItem(this.addForm.value)
      .subscribe( data => {
        console.log("here::",data);
        this.router.navigate(['listItems']);
      });
  }
  get f() { return this.addForm.controls; }

}
