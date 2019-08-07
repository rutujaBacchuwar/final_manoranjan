import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkTvPriComponent } from './link-tv-pri.component';

describe('LinkTvPriComponent', () => {
  let component: LinkTvPriComponent;
  let fixture: ComponentFixture<LinkTvPriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkTvPriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkTvPriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
