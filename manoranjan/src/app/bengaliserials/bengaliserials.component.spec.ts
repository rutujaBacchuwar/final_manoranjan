import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BengaliserialsComponent } from './bengaliserials.component';

describe('BengaliserialsComponent', () => {
  let component: BengaliserialsComponent;
  let fixture: ComponentFixture<BengaliserialsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BengaliserialsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BengaliserialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
