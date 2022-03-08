import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminEditComponent } from './menu-admin-edit.component';

describe('MenuAdminEditComponent', () => {
  let component: MenuAdminEditComponent;
  let fixture: ComponentFixture<MenuAdminEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
