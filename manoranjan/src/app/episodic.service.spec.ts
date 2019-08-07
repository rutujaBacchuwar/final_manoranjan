import { TestBed } from '@angular/core/testing';

import { EpisodicService } from './episodic.service';

describe('EpisodicService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EpisodicService = TestBed.get(EpisodicService);
    expect(service).toBeTruthy();
  });
});
