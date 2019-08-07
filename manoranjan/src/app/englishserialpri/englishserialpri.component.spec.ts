import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnglishserialpriComponent } from './englishserialpri.component';

describe('EnglishserialpriComponent', () => {
  let component: EnglishserialpriComponent;
  let fixture: ComponentFixture<EnglishserialpriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnglishserialpriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnglishserialpriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
