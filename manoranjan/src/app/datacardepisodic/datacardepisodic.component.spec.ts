import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DatacardepisodicComponent } from './datacardepisodic.component';

describe('DatacardepisodicComponent', () => {
  let component: DatacardepisodicComponent;
  let fixture: ComponentFixture<DatacardepisodicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DatacardepisodicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DatacardepisodicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
