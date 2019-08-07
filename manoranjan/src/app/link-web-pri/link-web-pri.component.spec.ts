import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkWebPriComponent } from './link-web-pri.component';

describe('LinkWebPriComponent', () => {
  let component: LinkWebPriComponent;
  let fixture: ComponentFixture<LinkWebPriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkWebPriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkWebPriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
