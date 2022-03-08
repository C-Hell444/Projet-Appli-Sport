import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuClubMembresEditComponent } from './menu-club-membres-edit.component';

describe('MenuClubMembresEditComponent', () => {
  let component: MenuClubMembresEditComponent;
  let fixture: ComponentFixture<MenuClubMembresEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuClubMembresEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuClubMembresEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
