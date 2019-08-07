import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MarathiserialpriComponent } from './marathiserialpri.component';

describe('MarathiserialpriComponent', () => {
  let component: MarathiserialpriComponent;
  let fixture: ComponentFixture<MarathiserialpriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MarathiserialpriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MarathiserialpriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
