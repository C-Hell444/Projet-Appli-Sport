import { TestBed } from '@angular/core/testing';

import { EvenementUtilisateurService } from './evenement-utilisateur.service';

describe('EvenementUtilisateurService', () => {
  let service: EvenementUtilisateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EvenementUtilisateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
