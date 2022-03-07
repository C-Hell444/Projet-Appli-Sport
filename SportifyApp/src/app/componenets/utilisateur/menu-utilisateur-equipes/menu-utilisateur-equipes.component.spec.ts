import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuUtilisateurEquipesComponent } from './menu-utilisateur-equipes.component';

describe('MenuUtilisateurEquipesComponent', () => {
  let component: MenuUtilisateurEquipesComponent;
  let fixture: ComponentFixture<MenuUtilisateurEquipesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuUtilisateurEquipesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuUtilisateurEquipesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
