import { TestBed } from '@angular/core/testing';

import { UserauthenService } from './userauthen.service';

describe('UserauthenService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserauthenService = TestBed.get(UserauthenService);
    expect(service).toBeTruthy();
  });
});
