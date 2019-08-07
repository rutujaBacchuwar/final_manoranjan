import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BiopicmoviepriComponent } from './biopicmoviepri.component';

describe('BiopicmoviepriComponent', () => {
  let component: BiopicmoviepriComponent;
  let fixture: ComponentFixture<BiopicmoviepriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BiopicmoviepriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BiopicmoviepriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
