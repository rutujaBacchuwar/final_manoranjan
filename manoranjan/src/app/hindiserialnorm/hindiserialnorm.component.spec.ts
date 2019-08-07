import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HindiserialnormComponent } from './hindiserialnorm.component';

describe('HindiserialnormComponent', () => {
  let component: HindiserialnormComponent;
  let fixture: ComponentFixture<HindiserialnormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HindiserialnormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HindiserialnormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
