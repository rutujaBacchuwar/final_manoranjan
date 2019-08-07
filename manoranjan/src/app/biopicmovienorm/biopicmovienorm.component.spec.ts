import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BiopicmovienormComponent } from './biopicmovienorm.component';

describe('BiopicmovienormComponent', () => {
  let component: BiopicmovienormComponent;
  let fixture: ComponentFixture<BiopicmovienormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BiopicmovienormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BiopicmovienormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
