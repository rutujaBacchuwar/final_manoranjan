import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StandaloneEpisodicComponent } from './standalone-episodic.component';

describe('StandaloneEpisodicComponent', () => {
  let component: StandaloneEpisodicComponent;
  let fixture: ComponentFixture<StandaloneEpisodicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StandaloneEpisodicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StandaloneEpisodicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
