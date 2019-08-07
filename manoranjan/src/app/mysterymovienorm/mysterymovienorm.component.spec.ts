import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MysterymovienormComponent } from './mysterymovienorm.component';

describe('MysterymovienormComponent', () => {
  let component: MysterymovienormComponent;
  let fixture: ComponentFixture<MysterymovienormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MysterymovienormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MysterymovienormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
