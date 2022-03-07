import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NosSportsComponent } from './nos-sports.component';

describe('NosSportsComponent', () => {
  let component: NosSportsComponent;
  let fixture: ComponentFixture<NosSportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NosSportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NosSportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
