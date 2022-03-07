import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NosClubsComponent } from './nos-clubs.component';

describe('NosClubsComponent', () => {
  let component: NosClubsComponent;
  let fixture: ComponentFixture<NosClubsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NosClubsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NosClubsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
