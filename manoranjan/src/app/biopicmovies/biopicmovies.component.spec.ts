import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BiopicmoviesComponent } from './biopicmovies.component';

describe('BiopicmoviesComponent', () => {
  let component: BiopicmoviesComponent;
  let fixture: ComponentFixture<BiopicmoviesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BiopicmoviesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BiopicmoviesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
