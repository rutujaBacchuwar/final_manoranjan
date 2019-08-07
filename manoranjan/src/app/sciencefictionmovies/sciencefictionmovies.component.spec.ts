import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SciencefictionmoviesComponent } from './sciencefictionmovies.component';

describe('SciencefictionmoviesComponent', () => {
  let component: SciencefictionmoviesComponent;
  let fixture: ComponentFixture<SciencefictionmoviesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SciencefictionmoviesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SciencefictionmoviesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
