import { TestBed } from '@angular/core/testing';

import { StandaloneService } from './standalone.service';

describe('StandaloneService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StandaloneService = TestBed.get(StandaloneService);
    expect(service).toBeTruthy();
  });
});
