import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SciencefictionmoviepriComponent } from './sciencefictionmoviepri.component';

describe('SciencefictionmoviepriComponent', () => {
  let component: SciencefictionmoviepriComponent;
  let fixture: ComponentFixture<SciencefictionmoviepriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SciencefictionmoviepriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SciencefictionmoviepriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
