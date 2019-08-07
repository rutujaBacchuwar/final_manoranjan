import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionmoviepriComponent } from './actionmoviepri.component';

describe('ActionmoviepriComponent', () => {
  let component: ActionmoviepriComponent;
  let fixture: ComponentFixture<ActionmoviepriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ActionmoviepriComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActionmoviepriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
