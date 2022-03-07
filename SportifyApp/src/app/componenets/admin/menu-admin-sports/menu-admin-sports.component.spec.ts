import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminSportsComponent } from './menu-admin-sports.component';

describe('MenuAdminSportsComponent', () => {
  let component: MenuAdminSportsComponent;
  let fixture: ComponentFixture<MenuAdminSportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminSportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminSportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
