import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MythologymoviepriComponent } from './mythologymoviepri.component';

describe('MythologymoviepriComponent', () => {
  let component: MythologymoviepriComponent;
  let fixture: ComponentFixture<MythologymoviepriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MythologymoviepriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MythologymoviepriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
