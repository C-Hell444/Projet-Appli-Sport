import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuClubEvenementsComponent } from './menu-club-evenements.component';

describe('MenuClubEvenementsComponent', () => {
  let component: MenuClubEvenementsComponent;
  let fixture: ComponentFixture<MenuClubEvenementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuClubEvenementsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuClubEvenementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
