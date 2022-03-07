import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuClubHistoriqueComponent } from './menu-club-historique.component';

describe('MenuClubHistoriqueComponent', () => {
  let component: MenuClubHistoriqueComponent;
  let fixture: ComponentFixture<MenuClubHistoriqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuClubHistoriqueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuClubHistoriqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
