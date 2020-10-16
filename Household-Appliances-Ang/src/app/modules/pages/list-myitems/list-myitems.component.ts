import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/core/model/item';
import { ApiService } from 'src/app/core/service/api.service';
import { Router } from '@angular/router';
import { SearchService } from 'src/app/core/service/search.service';
import { FormBuilder } from '@angular/forms';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-list-myitems',
  templateUrl: './list-myitems.component.html',
  styleUrls: ['./list-myitems.component.scss']
})
export class ListMyitemsComponent implements OnInit {

  items: Item[];
  results: Object;
  searchTerm$ = new Subject<string>();

  constructor(private router: Router, private apiService: ApiService,private searchService: SearchService,private fb: FormBuilder) {
    this.searchService.search(this.searchTerm$)
      .subscribe(results => {
        this.results = results.results;
      });
  }

  

  ngOnInit() {
    // if(!window.localStorage.getItem('token')) {
    //   this.router.navigate(['login']);
    //   return;
    // }
    this.items = this.apiService.getItems();
      // .subscribe( data => {
      //     console.log("here::",data);
      //     this.items = data.response;
      // });
  }

  deleteItem(item: Item): void {
    this.apiService.deleteItem(item.id)
      .subscribe( data => {
        this.items = this.items.filter(i => i !== item);
      })
  };

  updateItem(item: Item): void {
    window.localStorage.removeItem("itemId");
    window.localStorage.setItem("itemId", item.id.toString());
    this.router.navigate(['update-item',item.id]);
  };

  createItem(): void {
   
    this.router.navigate(['create-item']);
  };

}
