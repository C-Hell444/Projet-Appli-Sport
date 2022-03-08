import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminUtilisateursEditComponent } from './menu-admin-utilisateurs-edit.component';

describe('MenuAdminUtilisateursEditComponent', () => {
  let component: MenuAdminUtilisateursEditComponent;
  let fixture: ComponentFixture<MenuAdminUtilisateursEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminUtilisateursEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminUtilisateursEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
