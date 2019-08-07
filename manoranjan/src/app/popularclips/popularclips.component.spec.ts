import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopularclipsComponent } from './popularclips.component';

describe('PopularclipsComponent', () => {
  let component: PopularclipsComponent;
  let fixture: ComponentFixture<PopularclipsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopularclipsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopularclipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
