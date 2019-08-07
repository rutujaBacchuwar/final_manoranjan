import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnglishserialsComponent } from './englishserials.component';

describe('EnglishserialsComponent', () => {
  let component: EnglishserialsComponent;
  let fixture: ComponentFixture<EnglishserialsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnglishserialsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnglishserialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
