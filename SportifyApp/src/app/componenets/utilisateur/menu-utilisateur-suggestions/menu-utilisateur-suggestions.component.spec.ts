import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuUtilisateurSuggestionsComponent } from './menu-utilisateur-suggestions.component';

describe('MenuUtilisateurSuggestionsComponent', () => {
  let component: MenuUtilisateurSuggestionsComponent;
  let fixture: ComponentFixture<MenuUtilisateurSuggestionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuUtilisateurSuggestionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuUtilisateurSuggestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
