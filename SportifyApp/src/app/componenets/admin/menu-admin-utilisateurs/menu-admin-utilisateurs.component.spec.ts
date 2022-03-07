import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminUtilisateursComponent } from './menu-admin-utilisateurs.component';

describe('MenuAdminUtilisateursComponent', () => {
  let component: MenuAdminUtilisateursComponent;
  let fixture: ComponentFixture<MenuAdminUtilisateursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminUtilisateursComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminUtilisateursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
