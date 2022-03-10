import { TestBed } from '@angular/core/testing';

import { AuthenticationGardPourIncriptionEtConnexionService } from './authentication-gard-pour-incription-et-connexion.service';

describe('AuthenticationGardPourIncriptionEtConnexionService', () => {
  let service: AuthenticationGardPourIncriptionEtConnexionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenticationGardPourIncriptionEtConnexionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
