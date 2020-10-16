import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMyitemsComponent } from './list-myitems.component';

describe('ListMyitemsComponent', () => {
  let component: ListMyitemsComponent;
  let fixture: ComponentFixture<ListMyitemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListMyitemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMyitemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
