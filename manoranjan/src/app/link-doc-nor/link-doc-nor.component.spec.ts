import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkDocNorComponent } from './link-doc-nor.component';

describe('LinkDocNorComponent', () => {
  let component: LinkDocNorComponent;
  let fixture: ComponentFixture<LinkDocNorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkDocNorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkDocNorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
