import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminEquipesComponent } from './menu-admin-equipes.component';

describe('MenuAdminEquipesComponent', () => {
  let component: MenuAdminEquipesComponent;
  let fixture: ComponentFixture<MenuAdminEquipesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminEquipesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminEquipesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
