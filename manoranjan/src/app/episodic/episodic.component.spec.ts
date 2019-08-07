import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EpisodicComponent } from './episodic.component';

describe('EpisodicComponent', () => {
  let component: EpisodicComponent;
  let fixture: ComponentFixture<EpisodicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EpisodicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EpisodicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
