import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeluguserialsComponent } from './teluguserials.component';

describe('TeluguserialsComponent', () => {
  let component: TeluguserialsComponent;
  let fixture: ComponentFixture<TeluguserialsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeluguserialsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeluguserialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
