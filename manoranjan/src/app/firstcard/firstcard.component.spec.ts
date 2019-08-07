import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstcardComponent } from './firstcard.component';

describe('FirstcardComponent', () => {
  let component: FirstcardComponent;
  let fixture: ComponentFixture<FirstcardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FirstcardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FirstcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
