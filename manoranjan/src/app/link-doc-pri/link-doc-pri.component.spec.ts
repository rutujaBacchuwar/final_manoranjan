import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkDocPriComponent } from './link-doc-pri.component';

describe('LinkDocPriComponent', () => {
  let component: LinkDocPriComponent;
  let fixture: ComponentFixture<LinkDocPriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkDocPriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkDocPriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
