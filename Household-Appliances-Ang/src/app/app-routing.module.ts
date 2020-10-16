import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListMyitemsComponent } from './modules/pages/list-myitems/list-myitems.component';
import { CreateItemComponent } from './modules/pages/create-item/create-item.component';
import { UpdateItemComponent } from './modules/pages/update-item/update-item.component';

//const routes: Routes = [];
const routes: Routes = [
  //{ path: 'login', component: LoginComponent },
  {path : '', redirectTo: 'listItems', pathMatch: 'full'},
  { path: 'listItems', component: ListMyitemsComponent },
  { path: 'create-item', component: CreateItemComponent },
  { path: 'update-item/:itemId', component: UpdateItemComponent },
  
];

export const routing = RouterModule.forRoot(routes);
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
