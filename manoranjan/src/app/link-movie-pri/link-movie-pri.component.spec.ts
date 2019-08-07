import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkMoviePriComponent } from './link-movie-pri.component';

describe('LinkMoviePriComponent', () => {
  let component: LinkMoviePriComponent;
  let fixture: ComponentFixture<LinkMoviePriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkMoviePriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkMoviePriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
