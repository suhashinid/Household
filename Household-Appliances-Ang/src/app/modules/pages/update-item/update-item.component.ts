import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/core/model/item';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from 'src/app/core/service/api.service';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.scss']
})
export class UpdateItemComponent implements OnInit {

  id: number;
  item: Item;

  constructor(private route: ActivatedRoute,private router: Router,
    private apiService: ApiService) { }

  ngOnInit() {
   
    this.item = new Item();

    this.id = this.route.snapshot.params['itemId'];
    
    this.apiService.getItembyId(this.id)
      .subscribe(data => {
        console.log(data)
        this.item = data;
      }, error => console.log(error));
  }

  updateItem() {
    this.apiService.updateItem(this.item)
      .subscribe(data => {
        console.log(data);
        this.item = new Item();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateItem();    
  }

  gotoList() {
    this.router.navigate(['/listItems']);
  }

}
