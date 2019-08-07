import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditproducerprofileComponent } from './editproducerprofile.component';

describe('EditproducerprofileComponent', () => {
  let component: EditproducerprofileComponent;
  let fixture: ComponentFixture<EditproducerprofileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditproducerprofileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditproducerprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
