import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComedymoviepriComponent } from './comedymoviepri.component';

describe('ComedymoviepriComponent', () => {
  let component: ComedymoviepriComponent;
  let fixture: ComponentFixture<ComedymoviepriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComedymoviepriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComedymoviepriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
