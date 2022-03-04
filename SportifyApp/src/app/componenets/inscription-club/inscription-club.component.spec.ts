import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionClubComponent } from './inscription-club.component';

describe('InscriptionClubComponent', () => {
  let component: InscriptionClubComponent;
  let fixture: ComponentFixture<InscriptionClubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionClubComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionClubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
