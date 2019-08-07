import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RomanticmoviepriComponent } from './romanticmoviepri.component';

describe('RomanticmoviepriComponent', () => {
  let component: RomanticmoviepriComponent;
  let fixture: ComponentFixture<RomanticmoviepriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RomanticmoviepriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RomanticmoviepriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
