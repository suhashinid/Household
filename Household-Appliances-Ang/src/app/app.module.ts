import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { SearchMyappliancesComponent } from './modules/pages/search-myappliances/search-myappliances.component';
import { CreateItemComponent } from './modules/pages/create-item/create-item.component';
import { UpdateItemComponent } from './modules/pages/update-item/update-item.component';
import { RemoveItemComponent } from './modules/pages/remove-item/remove-item.component';
import { ListMyitemsComponent } from './modules/pages/list-myitems/list-myitems.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
   
    CreateItemComponent,
    UpdateItemComponent,
    RemoveItemComponent,
    ListMyitemsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    HttpModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
