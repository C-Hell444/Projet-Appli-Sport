import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuClubEvenementsEditComponent } from './menu-club-evenements-edit.component';

describe('MenuClubEvenementsEditComponent', () => {
  let component: MenuClubEvenementsEditComponent;
  let fixture: ComponentFixture<MenuClubEvenementsEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuClubEvenementsEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuClubEvenementsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
