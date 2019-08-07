import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnglishserialnormComponent } from './englishserialnorm.component';

describe('EnglishserialnormComponent', () => {
  let component: EnglishserialnormComponent;
  let fixture: ComponentFixture<EnglishserialnormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnglishserialnormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnglishserialnormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
