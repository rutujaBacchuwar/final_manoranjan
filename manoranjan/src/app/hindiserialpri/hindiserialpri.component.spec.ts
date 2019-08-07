import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HindiserialpriComponent } from './hindiserialpri.component';

describe('HindiserialpriComponent', () => {
  let component: HindiserialpriComponent;
  let fixture: ComponentFixture<HindiserialpriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HindiserialpriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HindiserialpriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
