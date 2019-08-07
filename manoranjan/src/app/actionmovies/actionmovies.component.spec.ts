import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionmoviesComponent } from './actionmovies.component';

describe('ActionmoviesComponent', () => {
  let component: ActionmoviesComponent;
  let fixture: ComponentFixture<ActionmoviesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActionmoviesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActionmoviesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
