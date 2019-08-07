import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThrillermoviesComponent } from './thrillermovies.component';

describe('ThrillermoviesComponent', () => {
  let component: ThrillermoviesComponent;
  let fixture: ComponentFixture<ThrillermoviesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThrillermoviesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThrillermoviesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
