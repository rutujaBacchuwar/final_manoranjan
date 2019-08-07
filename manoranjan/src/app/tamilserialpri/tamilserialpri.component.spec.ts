import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TamilserialpriComponent } from './tamilserialpri.component';

describe('TamilserialpriComponent', () => {
  let component: TamilserialpriComponent;
  let fixture: ComponentFixture<TamilserialpriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TamilserialpriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TamilserialpriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
