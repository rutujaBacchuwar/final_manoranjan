import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MythologymoviesComponent } from './mythologymovies.component';

describe('MythologymoviesComponent', () => {
  let component: MythologymoviesComponent;
  let fixture: ComponentFixture<MythologymoviesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MythologymoviesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MythologymoviesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
