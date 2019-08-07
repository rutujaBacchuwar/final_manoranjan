import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RomanticmoviesComponent } from './romanticmovies.component';

describe('RomanticmoviesComponent', () => {
  let component: RomanticmoviesComponent;
  let fixture: ComponentFixture<RomanticmoviesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RomanticmoviesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RomanticmoviesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
