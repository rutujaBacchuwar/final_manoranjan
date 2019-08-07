import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GujarathiserialnormComponent } from './gujarathiserialnorm.component';

describe('GujarathiserialnormComponent', () => {
  let component: GujarathiserialnormComponent;
  let fixture: ComponentFixture<GujarathiserialnormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GujarathiserialnormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GujarathiserialnormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
