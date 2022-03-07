import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NosEvenementsComponent } from './nos-evenements.component';

describe('NosEvenementsComponent', () => {
  let component: NosEvenementsComponent;
  let fixture: ComponentFixture<NosEvenementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NosEvenementsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NosEvenementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
