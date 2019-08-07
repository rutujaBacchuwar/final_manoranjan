import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProducerprofileComponent } from './producerprofile.component';

describe('ProducerprofileComponent', () => {
  let component: ProducerprofileComponent;
  let fixture: ComponentFixture<ProducerprofileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProducerprofileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProducerprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
