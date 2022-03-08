import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuUtilisateurHistoriqueEditComponent } from './menu-utilisateur-historique-edit.component';

describe('MenuUtilisateurHistoriqueEditComponent', () => {
  let component: MenuUtilisateurHistoriqueEditComponent;
  let fixture: ComponentFixture<MenuUtilisateurHistoriqueEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuUtilisateurHistoriqueEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuUtilisateurHistoriqueEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
