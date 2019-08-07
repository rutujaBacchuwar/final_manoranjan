import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SciencefictionmovienormComponent } from './sciencefictionmovienorm.component';

describe('SciencefictionmovienormComponent', () => {
  let component: SciencefictionmovienormComponent;
  let fixture: ComponentFixture<SciencefictionmovienormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SciencefictionmovienormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SciencefictionmovienormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
