import { Injectable } from '@angular/core';
import {Observable} from "rxjs/index";
import { HttpClient } from '@angular/common/http';
import { Item,ITEMS } from '../model/item';




@Injectable({
  providedIn: 'root'
})
export class ApiService {
  itemList = ITEMS;
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/items/';

//   login(login) : Observable<ApiResponse> {
//     return this.http.post<ApiResponse>('http://localhost:8080/'+ 'token/generate-token', login).pipe(
// catchError(val => of(val)));
// };
  

  getItems()  {
    // : Observable<Item[]>
    // return this.http.get<Object>(this.baseUrl);
    return this.itemList;
  }

  getItembyId(id: number): Observable<any> {
    return this.http.get<Object>(this.baseUrl + id);
  }

  createItem(item: Object): Observable<any> {
    return this.http.post<Object>(this.baseUrl, item);
  }

  updateItem(item: Item): Observable<any> {
    return this.http.put<Object>(this.baseUrl + item.id, item);
  }

  deleteItem(id: number): Observable<any> {
    return this.http.delete<Object>(this.baseUrl + id);
  }
}
