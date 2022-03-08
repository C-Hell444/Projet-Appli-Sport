import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminEvenementsEditComponent } from './menu-admin-evenements-edit.component';

describe('MenuAdminEvenementsEditComponent', () => {
  let component: MenuAdminEvenementsEditComponent;
  let fixture: ComponentFixture<MenuAdminEvenementsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminEvenementsEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminEvenementsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
