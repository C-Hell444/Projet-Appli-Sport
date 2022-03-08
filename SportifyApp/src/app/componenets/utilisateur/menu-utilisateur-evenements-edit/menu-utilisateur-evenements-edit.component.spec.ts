import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuUtilisateurEvenementsEditComponent } from './menu-utilisateur-evenements-edit.component';

describe('MenuUtilisateurEvenementsEditComponent', () => {
  let component: MenuUtilisateurEvenementsEditComponent;
  let fixture: ComponentFixture<MenuUtilisateurEvenementsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuUtilisateurEvenementsEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuUtilisateurEvenementsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
