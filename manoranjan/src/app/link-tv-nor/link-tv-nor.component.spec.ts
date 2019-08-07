import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkTvNorComponent } from './link-tv-nor.component';

describe('LinkTvNorComponent', () => {
  let component: LinkTvNorComponent;
  let fixture: ComponentFixture<LinkTvNorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkTvNorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkTvNorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
