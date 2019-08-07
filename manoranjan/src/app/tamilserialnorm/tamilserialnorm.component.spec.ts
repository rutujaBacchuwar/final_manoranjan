import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TamilserialnormComponent } from './tamilserialnorm.component';

describe('TamilserialnormComponent', () => {
  let component: TamilserialnormComponent;
  let fixture: ComponentFixture<TamilserialnormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TamilserialnormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TamilserialnormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
