import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkpriviewloginComponent } from './linkpriviewlogin.component';

describe('LinkpriviewloginComponent', () => {
  let component: LinkpriviewloginComponent;
  let fixture: ComponentFixture<LinkpriviewloginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkpriviewloginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkpriviewloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
