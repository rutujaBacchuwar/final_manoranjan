import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MarathiserialnormComponent } from './marathiserialnorm.component';

describe('MarathiserialnormComponent', () => {
  let component: MarathiserialnormComponent;
  let fixture: ComponentFixture<MarathiserialnormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MarathiserialnormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MarathiserialnormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
