import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminHistoriqueEditComponent } from './menu-admin-historique-edit.component';

describe('MenuAdminHistoriqueEditComponent', () => {
  let component: MenuAdminHistoriqueEditComponent;
  let fixture: ComponentFixture<MenuAdminHistoriqueEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminHistoriqueEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminHistoriqueEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
