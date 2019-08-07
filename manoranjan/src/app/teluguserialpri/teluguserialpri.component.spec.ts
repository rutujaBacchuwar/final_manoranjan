import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeluguserialpriComponent } from './teluguserialpri.component';

describe('TeluguserialpriComponent', () => {
  let component: TeluguserialpriComponent;
  let fixture: ComponentFixture<TeluguserialpriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeluguserialpriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeluguserialpriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
