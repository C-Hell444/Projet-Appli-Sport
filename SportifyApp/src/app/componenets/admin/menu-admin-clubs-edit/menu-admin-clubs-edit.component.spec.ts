import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminClubsEditComponent } from './menu-admin-clubs-edit.component';

describe('MenuAdminClubsEditComponent', () => {
  let component: MenuAdminClubsEditComponent;
  let fixture: ComponentFixture<MenuAdminClubsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminClubsEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminClubsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
