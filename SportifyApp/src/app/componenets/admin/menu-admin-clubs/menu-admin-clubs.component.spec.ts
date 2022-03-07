import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminClubsComponent } from './menu-admin-clubs.component';

describe('MenuAdminClubsComponent', () => {
  let component: MenuAdminClubsComponent;
  let fixture: ComponentFixture<MenuAdminClubsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminClubsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminClubsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
