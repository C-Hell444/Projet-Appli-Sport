import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminEquipesEditComponent } from './menu-admin-equipes-edit.component';

describe('MenuAdminEquipesEditComponent', () => {
  let component: MenuAdminEquipesEditComponent;
  let fixture: ComponentFixture<MenuAdminEquipesEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminEquipesEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminEquipesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
