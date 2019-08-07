import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BengaliserialnormComponent } from './bengaliserialnorm.component';

describe('BengaliserialnormComponent', () => {
  let component: BengaliserialnormComponent;
  let fixture: ComponentFixture<BengaliserialnormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BengaliserialnormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BengaliserialnormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
