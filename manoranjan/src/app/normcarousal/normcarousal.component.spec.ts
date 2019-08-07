import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NormcarousalComponent } from './normcarousal.component';

describe('NormcarousalComponent', () => {
  let component: NormcarousalComponent;
  let fixture: ComponentFixture<NormcarousalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NormcarousalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NormcarousalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
