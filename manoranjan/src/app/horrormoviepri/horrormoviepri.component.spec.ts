import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HorrormoviepriComponent } from './horrormoviepri.component';

describe('HorrormoviepriComponent', () => {
  let component: HorrormoviepriComponent;
  let fixture: ComponentFixture<HorrormoviepriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HorrormoviepriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HorrormoviepriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
