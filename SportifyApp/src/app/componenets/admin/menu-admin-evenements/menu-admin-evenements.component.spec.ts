import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminEvenementsComponent } from './menu-admin-evenements.component';

describe('MenuAdminEvenementsComponent', () => {
  let component: MenuAdminEvenementsComponent;
  let fixture: ComponentFixture<MenuAdminEvenementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminEvenementsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminEvenementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
