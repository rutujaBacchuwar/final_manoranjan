import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinknormviewComponent } from './linknormview.component';

describe('LinknormviewComponent', () => {
  let component: LinknormviewComponent;
  let fixture: ComponentFixture<LinknormviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinknormviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinknormviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
