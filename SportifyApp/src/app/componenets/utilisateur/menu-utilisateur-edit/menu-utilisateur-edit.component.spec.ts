import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuUtilisateurEditComponent } from './menu-utilisateur-edit.component';

describe('MenuUtilisateurEditComponent', () => {
  let component: MenuUtilisateurEditComponent;
  let fixture: ComponentFixture<MenuUtilisateurEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuUtilisateurEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuUtilisateurEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
