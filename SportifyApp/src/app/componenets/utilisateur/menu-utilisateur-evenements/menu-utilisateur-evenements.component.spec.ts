import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuUtilisateurEvenementsComponent } from './menu-utilisateur-evenements.component';

describe('MenuUtilisateurEvenementsComponent', () => {
  let component: MenuUtilisateurEvenementsComponent;
  let fixture: ComponentFixture<MenuUtilisateurEvenementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuUtilisateurEvenementsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuUtilisateurEvenementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
