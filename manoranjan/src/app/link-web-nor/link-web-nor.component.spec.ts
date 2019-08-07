import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkWebNorComponent } from './link-web-nor.component';

describe('LinkWebNorComponent', () => {
  let component: LinkWebNorComponent;
  let fixture: ComponentFixture<LinkWebNorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkWebNorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkWebNorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
