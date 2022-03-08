import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuClubHistoriqueEditComponent } from './menu-club-historique-edit.component';

describe('MenuClubHistoriqueEditComponent', () => {
  let component: MenuClubHistoriqueEditComponent;
  let fixture: ComponentFixture<MenuClubHistoriqueEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuClubHistoriqueEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuClubHistoriqueEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
