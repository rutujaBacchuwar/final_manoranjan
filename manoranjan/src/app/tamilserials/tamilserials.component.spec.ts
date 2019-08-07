import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TamilserialsComponent } from './tamilserials.component';

describe('TamilserialsComponent', () => {
  let component: TamilserialsComponent;
  let fixture: ComponentFixture<TamilserialsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TamilserialsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TamilserialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
