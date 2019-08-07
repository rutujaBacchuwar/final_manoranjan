import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavLandComponent } from './nav-land.component';

describe('NavLandComponent', () => {
  let component: NavLandComponent;
  let fixture: ComponentFixture<NavLandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavLandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavLandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
