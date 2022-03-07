import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdminHistoriqueComponent } from './menu-admin-historique.component';

describe('MenuAdminHistoriqueComponent', () => {
  let component: MenuAdminHistoriqueComponent;
  let fixture: ComponentFixture<MenuAdminHistoriqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdminHistoriqueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdminHistoriqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
