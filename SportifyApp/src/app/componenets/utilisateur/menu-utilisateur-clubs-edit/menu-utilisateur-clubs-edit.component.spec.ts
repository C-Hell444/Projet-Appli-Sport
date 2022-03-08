import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuUtilisateurClubsEditComponent } from './menu-utilisateur-clubs-edit.component';

describe('MenuUtilisateurClubsEditComponent', () => {
  let component: MenuUtilisateurClubsEditComponent;
  let fixture: ComponentFixture<MenuUtilisateurClubsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuUtilisateurClubsEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuUtilisateurClubsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
