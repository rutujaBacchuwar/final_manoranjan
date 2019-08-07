import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionmovienormComponent } from './actionmovienorm.component';

describe('ActionmovienormComponent', () => {
  let component: ActionmovienormComponent;
  let fixture: ComponentFixture<ActionmovienormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActionmovienormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActionmovienormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
