import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkpriviewComponent } from './linkpriview.component';

describe('LinkpriviewComponent', () => {
  let component: LinkpriviewComponent;
  let fixture: ComponentFixture<LinkpriviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkpriviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkpriviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
