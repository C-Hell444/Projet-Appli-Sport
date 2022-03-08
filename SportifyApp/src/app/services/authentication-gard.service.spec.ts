import { TestBed } from '@angular/core/testing';

import { AuthenticationGardService } from './authentication-gard.service';

describe('AuthenticationGardService', () => {
  let service: AuthenticationGardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenticationGardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
