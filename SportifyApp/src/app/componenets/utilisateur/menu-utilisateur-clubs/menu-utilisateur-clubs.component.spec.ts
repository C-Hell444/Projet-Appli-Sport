import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuUtilisateurClubsComponent } from './menu-utilisateur-clubs.component';

describe('MenuUtilisateurClubsComponent', () => {
  let component: MenuUtilisateurClubsComponent;
  let fixture: ComponentFixture<MenuUtilisateurClubsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuUtilisateurClubsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuUtilisateurClubsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
