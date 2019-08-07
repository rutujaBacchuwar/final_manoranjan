import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BengaliserialpriComponent } from './bengaliserialpri.component';

describe('BengaliserialpriComponent', () => {
  let component: BengaliserialpriComponent;
  let fixture: ComponentFixture<BengaliserialpriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BengaliserialpriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BengaliserialpriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
