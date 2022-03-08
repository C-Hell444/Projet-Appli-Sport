import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuClubEquipesEditComponent } from './menu-club-equipes-edit.component';

describe('MenuClubEquipesEditComponent', () => {
  let component: MenuClubEquipesEditComponent;
  let fixture: ComponentFixture<MenuClubEquipesEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuClubEquipesEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuClubEquipesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
