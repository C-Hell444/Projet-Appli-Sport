import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminSportsEditComponent } from './menu-admin-sports-edit.component';

describe('MenuAdminSportsEditComponent', () => {
  let component: MenuAdminSportsEditComponent;
  let fixture: ComponentFixture<MenuAdminSportsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminSportsEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminSportsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
