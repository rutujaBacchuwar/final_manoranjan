import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavNormComponent } from './nav-norm.component';

describe('NavNormComponent', () => {
  let component: NavNormComponent;
  let fixture: ComponentFixture<NavNormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavNormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavNormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
