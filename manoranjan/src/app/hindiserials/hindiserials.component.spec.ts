import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HindiserialsComponent } from './hindiserials.component';

describe('HindiserialsComponent', () => {
  let component: HindiserialsComponent;
  let fixture: ComponentFixture<HindiserialsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HindiserialsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HindiserialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
