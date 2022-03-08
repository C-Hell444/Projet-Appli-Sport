import { TestBed } from '@angular/core/testing';

import { EquipeUtilisateurService } from './equipe-utilisateur.service';

describe('EquipeUtilisateurService', () => {
  let service: EquipeUtilisateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EquipeUtilisateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
