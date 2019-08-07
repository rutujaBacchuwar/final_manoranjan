import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MysterymoviepriComponent } from './mysterymoviepri.component';

describe('MysterymoviepriComponent', () => {
  let component: MysterymoviepriComponent;
  let fixture: ComponentFixture<MysterymoviepriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MysterymoviepriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MysterymoviepriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
