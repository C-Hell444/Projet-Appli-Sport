import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuClubEditComponent } from './menu-club-edit.component';

describe('MenuClubEditComponent', () => {
  let component: MenuClubEditComponent;
  let fixture: ComponentFixture<MenuClubEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuClubEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuClubEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
