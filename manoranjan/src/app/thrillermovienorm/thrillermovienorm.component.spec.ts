import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThrillermovienormComponent } from './thrillermovienorm.component';

describe('ThrillermovienormComponent', () => {
  let component: ThrillermovienormComponent;
  let fixture: ComponentFixture<ThrillermovienormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThrillermovienormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThrillermovienormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
