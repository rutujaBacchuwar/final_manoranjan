import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RomanticmovienormComponent } from './romanticmovienorm.component';

describe('RomanticmovienormComponent', () => {
  let component: RomanticmovienormComponent;
  let fixture: ComponentFixture<RomanticmovienormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RomanticmovienormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RomanticmovienormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
