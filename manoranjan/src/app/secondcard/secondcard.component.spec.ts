import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SecondcardComponent } from './secondcard.component';

describe('SecondcardComponent', () => {
  let component: SecondcardComponent;
  let fixture: ComponentFixture<SecondcardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecondcardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecondcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
