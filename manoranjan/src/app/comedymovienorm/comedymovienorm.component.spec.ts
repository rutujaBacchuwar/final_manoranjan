import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComedymovienormComponent } from './comedymovienorm.component';

describe('ComedymovienormComponent', () => {
  let component: ComedymovienormComponent;
  let fixture: ComponentFixture<ComedymovienormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComedymovienormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComedymovienormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
