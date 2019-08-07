import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GujarathiserialsComponent } from './gujarathiserials.component';

describe('GujarathiserialsComponent', () => {
  let component: GujarathiserialsComponent;
  let fixture: ComponentFixture<GujarathiserialsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GujarathiserialsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GujarathiserialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
