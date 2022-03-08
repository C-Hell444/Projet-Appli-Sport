import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuUtilisateurEquipesEditComponent } from './menu-utilisateur-equipes-edit.component';

describe('MenuUtilisateurEquipesEditComponent', () => {
  let component: MenuUtilisateurEquipesEditComponent;
  let fixture: ComponentFixture<MenuUtilisateurEquipesEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuUtilisateurEquipesEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuUtilisateurEquipesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
