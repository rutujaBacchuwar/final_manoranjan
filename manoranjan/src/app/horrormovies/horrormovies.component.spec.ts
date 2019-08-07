import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HorrormoviesComponent } from './horrormovies.component';

describe('HorrormoviesComponent', () => {
  let component: HorrormoviesComponent;
  let fixture: ComponentFixture<HorrormoviesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HorrormoviesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HorrormoviesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
