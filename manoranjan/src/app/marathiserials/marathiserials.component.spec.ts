import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MarathiserialsComponent } from './marathiserials.component';

describe('MarathiserialsComponent', () => {
  let component: MarathiserialsComponent;
  let fixture: ComponentFixture<MarathiserialsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MarathiserialsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MarathiserialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
