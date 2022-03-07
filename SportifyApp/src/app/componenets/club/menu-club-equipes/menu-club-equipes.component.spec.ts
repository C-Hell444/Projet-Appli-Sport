import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuClubEquipesComponent } from './menu-club-equipes.component';

describe('MenuClubEquipesComponent', () => {
  let component: MenuClubEquipesComponent;
  let fixture: ComponentFixture<MenuClubEquipesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuClubEquipesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuClubEquipesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
