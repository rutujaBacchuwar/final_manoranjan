import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThirdcardComponent } from './thirdcard.component';

describe('ThirdcardComponent', () => {
  let component: ThirdcardComponent;
  let fixture: ComponentFixture<ThirdcardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThirdcardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThirdcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
