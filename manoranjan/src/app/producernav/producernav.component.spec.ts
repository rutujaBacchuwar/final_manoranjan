import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProducernavComponent } from './producernav.component';

describe('ProducernavComponent', () => {
  let component: ProducernavComponent;
  let fixture: ComponentFixture<ProducernavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProducernavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProducernavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
