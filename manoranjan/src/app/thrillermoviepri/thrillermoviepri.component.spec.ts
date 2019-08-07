import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThrillermoviepriComponent } from './thrillermoviepri.component';

describe('ThrillermoviepriComponent', () => {
  let component: ThrillermoviepriComponent;
  let fixture: ComponentFixture<ThrillermoviepriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThrillermoviepriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThrillermoviepriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
