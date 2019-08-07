import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkMovieNorComponent } from './link-movie-nor.component';

describe('LinkMovieNorComponent', () => {
  let component: LinkMovieNorComponent;
  let fixture: ComponentFixture<LinkMovieNorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkMovieNorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkMovieNorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
