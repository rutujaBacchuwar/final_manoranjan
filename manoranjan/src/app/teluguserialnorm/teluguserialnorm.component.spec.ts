import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeluguserialnormComponent } from './teluguserialnorm.component';

describe('TeluguserialnormComponent', () => {
  let component: TeluguserialnormComponent;
  let fixture: ComponentFixture<TeluguserialnormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeluguserialnormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeluguserialnormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
