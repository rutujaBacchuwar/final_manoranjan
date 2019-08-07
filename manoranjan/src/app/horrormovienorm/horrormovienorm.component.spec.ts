import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HorrormovienormComponent } from './horrormovienorm.component';

describe('HorrormovienormComponent', () => {
  let component: HorrormovienormComponent;
  let fixture: ComponentFixture<HorrormovienormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HorrormovienormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HorrormovienormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
