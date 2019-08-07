import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EpisoderecommendationComponent } from './episoderecommendation.component';

describe('EpisoderecommendationComponent', () => {
  let component: EpisoderecommendationComponent;
  let fixture: ComponentFixture<EpisoderecommendationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EpisoderecommendationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EpisoderecommendationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
