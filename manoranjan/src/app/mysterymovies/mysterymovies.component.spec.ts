import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MysterymoviesComponent } from './mysterymovies.component';

describe('MysterymoviesComponent', () => {
  let component: MysterymoviesComponent;
  let fixture: ComponentFixture<MysterymoviesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MysterymoviesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MysterymoviesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
