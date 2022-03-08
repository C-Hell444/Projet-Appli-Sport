import { TestBed } from '@angular/core/testing';

import { ClubUtilisateurService } from './club-utilisateur.service';

describe('ClubUtilisateurService', () => {
  let service: ClubUtilisateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClubUtilisateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
