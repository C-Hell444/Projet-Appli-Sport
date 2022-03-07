import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuClubMembresComponent } from './menu-club-membres.component';

describe('MenuClubMembresComponent', () => {
  let component: MenuClubMembresComponent;
  let fixture: ComponentFixture<MenuClubMembresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuClubMembresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuClubMembresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
