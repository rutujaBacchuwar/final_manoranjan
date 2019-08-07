import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MythologymovienormComponent } from './mythologymovienorm.component';

describe('MythologymovienormComponent', () => {
  let component: MythologymovienormComponent;
  let fixture: ComponentFixture<MythologymovienormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MythologymovienormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MythologymovienormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
