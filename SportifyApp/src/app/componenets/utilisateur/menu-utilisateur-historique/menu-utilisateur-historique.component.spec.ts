import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuUtilisateurHistoriqueComponent } from './menu-utilisateur-historique.component';

describe('MenuUtilisateurHistoriqueComponent', () => {
  let component: MenuUtilisateurHistoriqueComponent;
  let fixture: ComponentFixture<MenuUtilisateurHistoriqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuUtilisateurHistoriqueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuUtilisateurHistoriqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
