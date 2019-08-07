import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StandaloneStepperComponent } from './standalone-stepper.component';

describe('StandaloneStepperComponent', () => {
  let component: StandaloneStepperComponent;
  let fixture: ComponentFixture<StandaloneStepperComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StandaloneStepperComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StandaloneStepperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
