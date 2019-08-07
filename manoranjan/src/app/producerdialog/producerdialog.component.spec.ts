import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProducerdialogComponent } from './producerdialog.component';

describe('ProducerdialogComponent', () => {
  let component: ProducerdialogComponent;
  let fixture: ComponentFixture<ProducerdialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProducerdialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProducerdialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
